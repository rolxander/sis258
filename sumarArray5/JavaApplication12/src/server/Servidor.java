/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author MPC
 */
public class Servidor implements Runnable{
    public Servidor(){
     Thread mi_hilo = new Thread(this);
     mi_hilo.start();
    }

    @Override
    public void run() {
        try{
            ServerSocket servidor  = new ServerSocket(9999);
            int vectorRecibido[];
            
            while(true){
                Socket misocket = servidor.accept();
                String ipRespuesta = misocket.getLocalAddress().toString();
                ObjectInputStream flujo_entrada = new ObjectInputStream(misocket.getInputStream());
                vectorRecibido = (int[]) flujo_entrada.readObject();
                for(int a = 0; a<vectorRecibido.length;a++){
                       vectorRecibido[a] = vectorRecibido[a]+=5;
                }
                int vectorRespueta[] = vectorRecibido;
                Socket respuesta = new Socket(ipRespuesta,9998);
                ObjectOutputStream flujo_respuesta = new ObjectOutputStream(respuesta.getOutputStream());
                flujo_respuesta.writeObject(vectorRespueta);
                flujo_respuesta.close();
                respuesta.close();
                System.out.print("Vector mandado");
            }
            
        }catch(Exception e){
            System.out.printf(e.getMessage());
        }
    }
    
}
