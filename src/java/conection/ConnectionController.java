/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Antonio-PC
 */
public class ConnectionController {

    String user = "root";
    String password = "root";
    String port = "3306";
    String database = "NotasCastores";//nombre de la base de datos  local adjunta en 
    //la carpeta de documentacion de proyecto como Notas.sql
    String server = "localhost";
    String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    String urlConnection = "jdbc:mysql://" + server + ":" + port + "/" + database;

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
