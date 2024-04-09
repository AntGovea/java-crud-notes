/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import conection.ConnectionController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Utilidades;

/**
 *
 * @author Antonio-PC
 */
public class NoteController {

    public boolean addNote(String title, String description, int idUsuario) {

        boolean validation = false;
        Connection conn = null;
        PreparedStatement stmt = null;
        ConnectionController cc = new ConnectionController();
        Utilidades util = new Utilidades();

        try {

            conn = cc.openConnection();
            String sql = "INSERT INTO notas(title,description,idUsuario,date) VALUES(?,?,?,?);";
            stmt = conn.prepareStatement(sql);
            stmt.setString(0, title);
            stmt.setString(1, description);
            stmt.setInt(2, idUsuario);
            stmt.setLong(2, util.getCurrentTimeStamp());

            validation = true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return validation;
    }

}
