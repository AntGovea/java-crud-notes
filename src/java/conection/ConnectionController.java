/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Antonio-PC
 */
public class ConnectionController {

    String user = "root";
    String password = "root";
    String port = "3306";
    String database = "NotasCastores";
    String server = "localhost";
    String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    ResultSet resultset = null;
    String urlConnection = "jdbc:mysql://" + server + ":" + port + "/" + database;

    public void connectDatabase(String title, String description, int idUsuario) {

        try {
            Class.forName(JDBC_DRIVER);

        } catch (Exception e) {
            System.out.println("e = " + e);
        }
        try ( Connection conn = DriverManager.getConnection(urlConnection, user, password)) {
            String sql = "INSERT INTO usuarios (userType,userName,userPassword,idPersona) VALUES (?, ?, ?);";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setString(2, description);
            stmt.setInt(3, idUsuario);
            System.out.println("sql = " + sql);
            int rows = stmt.executeUpdate(sql);
            System.out.println("rows = " + rows);
//
//            while (resultset.next()) {
//                int id = resultset.getInt("idNota");
//                String titulo = resultset.getString("title");
//                String desc = resultset.getString("description");
//                System.out.println("id" + id + " " + "titulo" + titulo + " " + "desc" + desc + " ");
//
//            }

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error al insertar la nota: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Connection registerNewUser(
            String apePaterno,
            String apeMaterno,
            String nombre,
            String direccion,
            String usuario,
            String contrasena) {
        Date fechaActual = new Date();
        long timestamp = fechaActual.getTime() / 1000;
        boolean validation = false;
        System.out.println("UNIX timestamp actual: " + timestamp);
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);

        } catch (Exception e) {
            System.out.println("e = " + e);
        }

        try {

            conn = DriverManager.getConnection(urlConnection, user, password);

            String sql = "INSERT INTO personal (apePaterno, apeMaterno, nombre, direccion, fechadeIngreso) VALUES (?, ?, ?, ?, ?);";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, apePaterno);
            stmt.setString(2, apeMaterno);
            stmt.setString(3, nombre);
            stmt.setString(4, direccion);
            stmt.setLong(5, timestamp);
//            stmt.setString(6, usuario);
//            stmt.setString(7, contrasena);
            System.out.println("sql = " + sql);
            int rows = stmt.executeUpdate();
            System.out.println("filas afectadas" + rows);
            if (rows > 0) {
                validation = true;

                return true;
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos MySQL: " + e.getMessage());

        }

        return validation;
    }

    public Connection openConnection() {

        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);

        } catch (Exception e) {
            System.out.println("e = " + e);
        }

        try {
            conn = DriverManager.getConnection(urlConnection, user, password);

        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos MySQL: " + e.getMessage());

        }

        return conn;
    }

    public void closeConnection(Connection conn) {

        try {
            conn.close();

        } catch (Exception e) {
            System.out.println("e = " + e);
        }

    }
}
