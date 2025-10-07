package org;
import java.io.*;
import java.net.*;

public class PeerClient {
   public PeerClient(String addr, int port,String filePath ){
     try {
         Socket s = new Socket(addr,port);
         System.out.println("connected to server");
         DataOutputStream out = new DataOutputStream(s.getOutputStream());

         //open file
         File file = new File(filePath);
         FileInputStream fileIn = new FileInputStream(file);

         //send the file size first
         out.writeLong(file.length());
         byte[] buffer = new byte[4096];
         int bytesRead;
         while ((bytesRead = fileIn.read(buffer)) != -1) {
             out.write(buffer, 0, bytesRead);
         }
         out.flush();
         fileIn.close();
         System.out.println("File sent successfully");

         // close connection
         out.close();
         s.close();


     }catch (UnknownHostException u) {
           System.out.println(u);
       } catch (IOException i) {
           System.out.println(i);
       }
     }

     public  static void main(String[] args){
       PeerClient pc = new PeerClient("127.0.0.1", 5000, "/home/marwa/keys.text");
     }
}
