/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Date;

/**
 *
 * @author Antonio-PC
 */
public class Utilidades {

    public long getCurrentTimeStamp() {
        Date fechaActual = new Date();
        long timesStamp = fechaActual.getTime() / 1000;
        return timesStamp;
    }

}
