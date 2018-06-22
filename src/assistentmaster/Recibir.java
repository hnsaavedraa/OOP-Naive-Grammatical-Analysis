/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistentmaster;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author jsg11
 */
public class Recibir {
    ServerSocket server;
    Socket connection;

    DataOutputStream output;
    BufferedInputStream bis;
    BufferedOutputStream bos;

    byte[] receivedData;
    int in;
    String file;
    public Recibir(){
        
    }
    public void iniciarConeccion(int port){
        try{
            //Servidor Socket en el puerto 5000
            server = new ServerSocket(port);
            while (true) {
                //Aceptar conexiones
                connection = server.accept();
                //Buffer de 1024 bytes
                receivedData = new byte[8192];
                bis = new BufferedInputStream(connection.getInputStream());
                DataInputStream dis = new DataInputStream(connection.getInputStream());
                //Recibimos el nombre del fichero
                file = dis.readUTF();
                file = file.substring(file.indexOf('\\') + 1, file.length());
                //Para guardar fichero recibido
                bos = new BufferedOutputStream(new FileOutputStream("Word2Graph\\Texts\\"+file));
                while ((in = bis.read(receivedData)) != -1) {
                    bos.write(receivedData, 0, in);
                }
                bos.close();
                dis.close();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        try{
            connection.close();
        }catch(Exception e){
            System.err.println(e);
        }
    }
    
}