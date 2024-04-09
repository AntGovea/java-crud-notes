/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import conection.ConnectionController;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Persona;
import model.Usuario;
import util.Utilidades;

/**
 *
 * @author Antonio-PC
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    ConnectionController cc = new ConnectionController();
    Utilidades util = new Utilidades();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String action = request.getParameter("action");

        if (action.equals("Registrar")) {
            registerUser(request, response);
        } else {
            loginUser(request, response);
        }
    }

    public void registerUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Persona p = new Persona();
        String apePaterno = request.getParameter("apePaterno");
        String apeMaterno = request.getParameter("apeMaterno");
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        //aqui se pueden agregar validaciones de los campos, pero por el moemento se omitira ese paso
        //ya que no es requerido en este ejercicio 
        try {

            Connection conn = cc.openConnection();

            p.setApePaterno(apePaterno);
            p.setApeMaterno(apeMaterno);
            p.setNombre(nombre);
            p.setDireccion(direccion);
            p.setFechadeIngreso(util.getCurrentTimeStamp());
            String sqlPersona = "INSERT INTO personal(apePaterno, apeMaterno, nombre, direccion, fechadeIngreso)VALUES(?,?,?,?,?);";
            PreparedStatement stmt = conn.prepareStatement(sqlPersona, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, p.getApePaterno());
            stmt.setString(2, p.getApeMaterno());
            stmt.setString(3, p.getNombre());
            stmt.setString(4, p.getDireccion());
            stmt.setLong(5, p.getFechadeIngreso());
            int rowsAfected = stmt.executeUpdate();

            if (rowsAfected == 0) {
                cc.closeConnection(conn);

            }

            ResultSet generatedKeys = stmt.getGeneratedKeys();

            if (generatedKeys.next()) {
                p.setIdPersona(generatedKeys.getInt(1));
            }
            //Insercion de usuario con la persona insertada previamente
            //esto se puede hacer mediante una transaccion sqlPersona para prevenir errores de registro y tener un fujo controlado
            //pero no es obligatorio en este ejercicio 
            Usuario u = new Usuario();

            u.setUserType(Integer.parseInt(request.getParameter("tipoUsuario")));
            u.setUserPassword(request.getParameter("contrasena"));
            u.setUserName(request.getParameter("usuario"));
            u.setPersona(p);

            String sqlUsuario = "INSERT INTO usuarios(userType,userName,userPassword,idPersona) VALUES (?, ?, ?, ?);";

            stmt = conn.prepareStatement(sqlUsuario);
            stmt.setInt(1, u.getUserType());
            stmt.setString(2, u.getUserName());
            stmt.setString(3, u.getUserPassword());
            stmt.setInt(4, p.getIdPersona());

            rowsAfected = stmt.executeUpdate();
            if (rowsAfected == 0) {
                cc.closeConnection(conn);

            }
            response.sendRedirect("/crud-noticias/vistas/Login.jsp");

        } catch (SQLException ex) {

            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loginUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {

            Connection conn = cc.openConnection();
            //al guardar la contraseña en la base de datos es preferible encriptarla
            //en este ejercicio no es obligatorio
            String sql = "SELECT * FROM usuarios WHERE userName=? AND  userPassword=?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, request.getParameter("usuario"));
            stmt.setString(2, request.getParameter("contrasena"));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                response.sendRedirect("/crud-noticias/vistas/CapturaNoticias.jsp");
            }

        } catch (SQLException ex) {
        }

    }
}
