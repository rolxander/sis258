/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import server.Servidor;
/**
 *
 * @author MPC
 */
public class JavaApplication12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
            new Servidor();
        }catch(Exception e){
        }
    }
    
}
