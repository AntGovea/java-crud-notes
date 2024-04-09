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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Persona;
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
        System.out.println("si entra al metodo");

        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");
        String action = request.getParameter("action");
       
        if (action.equals("Registrar")) {
            registerUser(request);
        } else {
            loginUser();
        }

        System.out.println("usuario" + usuario);
        long tiempoActualMillis = System.currentTimeMillis();

        // Convertir los milisegundos a segundos (dividir por 1000)
    }

    public boolean registerUser(HttpServletRequest request) {
        boolean validation = false;
        Persona p = new Persona();
        String apePaterno = request.getParameter("apePaterno");
        String apeMaterno = request.getParameter("apeMaterno");
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        //aqui se pueden agregar validaciones de los campos, pero por el moemento se omitira ese paso
        //ya que no es requerido en este ejercisio 
        try {

            Connection conn = cc.openConnection();

            p.setApePaterno(apePaterno);
            p.setApeMaterno(apeMaterno);
            p.setNombre(nombre);
            p.setDireccion(direccion);
            p.setFechadeIngreso(util.getCurrentTimeStamp());

            String sql = "INSERT INTO persona(apePaterno, apeMaterno, nombre, direccion, fechadeIngreso)VALUES(?,?,?,?,?);";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, p.getApePaterno());
            stmt.setString(2, p.getApeMaterno());
            stmt.setString(3, p.getNombre());
            stmt.setString(4, p.getDireccion());
            stmt.setLong(5, p.getFechadeIngreso());
            int rowsAfected = stmt.executeUpdate();

            if (rowsAfected > 0) {
                cc.closeConnection(conn);
                validation = true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return validation;
    }

    public void loginUser() {

    }

}
