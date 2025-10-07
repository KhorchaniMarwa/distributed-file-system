package org;

import java.io.*;
import java.net.*;

public class PeerServer {

    private ServerSocket serverSocket;

    public PeerServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);
            System.out.println("Waiting for a client ...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client accepted");

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());

            // read file size
            long fileSize = in.readLong();
            System.out.println("Expecting file of size: " + fileSize + " bytes");

            // create file to save
            FileOutputStream fos = new FileOutputStream("received_keys.text");
            byte[] buffer = new byte[4096];
            int bytesRead;
            long totalRead = 0;

            while (totalRead < fileSize && (bytesRead = in.read(buffer, 0, (int)Math.min(buffer.length, fileSize - totalRead))) != -1) {
                fos.write(buffer, 0, bytesRead);
                totalRead += bytesRead;
            }

            fos.close();
            System.out.println("File received successfully.");

            // close streams and sockets
            in.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PeerServer(5000);
    }
}
