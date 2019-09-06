/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author MPC
 */
public class Cliente { public static void main(String[] args) {
       
    String valor ="5";    
        do{
        System.out.print("Introduce el numero de elementos que quieras ingresar del 1-99\n");
        Scanner sc = new Scanner(System.in);
        valor = sc.nextLine();
    }while(!(valor.matches("[0-9]{1,2}")));
    int cantidad =  Integer.parseInt(valor);
    int vector[];
    vector  = new int[cantidad];
    Scanner valorVector = new Scanner(System.in);
    for(int contador =0; contador<cantidad ;contador++){
            System.out.print("Introduce un valor en el vector\n");
            vector[contador] = Integer.parseInt(valorVector.nextLine());
        }
    try{
        Socket misocket =  new Socket("192.168.1.128",9999);
        ObjectOutputStream flujo_salida = new ObjectOutputStream(misocket.getOutputStream());
        flujo_salida.writeObject(vector);
        flujo_salida.close();
        misocket.close();
        
        ////////////////////
        while(true){
            ServerSocket servidor = new ServerSocket(9998);
            int vectorRecibido[];
            Socket misocketR = servidor.accept();
            ObjectInputStream flujo_entrada = new ObjectInputStream(misocketR.getInputStream());
            vectorRecibido = (int[]) flujo_entrada.readObject();
            flujo_entrada.close();
            misocketR.close();
            servidor.close();
            System.out.printf("El vector recibido es:");
            for(int a = 0; a<vectorRecibido.length;a++){
                       System.out.print(vectorRecibido[a]);
                       if(vectorRecibido.length!=a){
                           System.out.print("-");
                       }
            }
        }
        /////////////////////
        
    }
    catch(Exception e){
        System.out.print(e.getMessage());
     }
    }
    
}
