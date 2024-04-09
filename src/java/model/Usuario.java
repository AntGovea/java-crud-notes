/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Antonio-PC
 */
public class Usuario {

    private int userType;
    private int userName;
    private int userPassword;
    private Persona persona;

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getUserName() {
        return userName;
    }

    public void setUserName(int userName) {
        this.userName = userName;
    }

    public int getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(int userPassword) {
        this.userPassword = userPassword;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
