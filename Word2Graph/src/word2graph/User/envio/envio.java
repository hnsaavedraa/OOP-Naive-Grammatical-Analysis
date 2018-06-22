/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package word2graph.User.envio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author jsg11
 */
public class envio {
    private Socket client;
    DataInputStream input;
        BufferedInputStream bis;
        BufferedOutputStream bos;
        int in;
        byte[] byteArray;
        ArrayList<String> archivos;
      ArrayList<String> directorios;//esto debe salir de la interfaz  
  public envio(){
      
     
}
  public void establecerConexion(String ip,int port,ArrayList<String> directorios, String name) {
       try{
      this.client= new Socket(ip,port);
      this.directorios=directorios;
      }catch(IOException e){
          System.err.println(e);
      }
          
          try{ 
              
                  System.out.println(name);
                  final String filename = name;
                  final File localFile = new File(filename);
                  bis = new BufferedInputStream(new FileInputStream(localFile));
                  bos = new BufferedOutputStream(client.getOutputStream());
                  DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                  dos.writeUTF(localFile.getName());
                  
                  byteArray = new byte[8192];
                  while((in = bis.read(byteArray))!=-1){
                      bos.write(byteArray,0,in);
                  }
                
              
            bis.close();
            bos.close();
          }catch(IOException e){
              System.err.println(e);
          }
      
  } 
}
