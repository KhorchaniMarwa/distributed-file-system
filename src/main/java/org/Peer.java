package org;

import java.util.ArrayList;

public class Peer {
    private int peerID;
    private String IP;
    private int port;
    private ArrayList<String> ownedFiles = new ArrayList();

    public  Peer(int peerID,int port,String IP, ArrayList<String> ownedFiles){
        this.peerID = peerID;
        this.port = port;
        this.IP = IP;
        this.ownedFiles = ownedFiles;
    }
    
    public static void main (String[] args){
        PeerServer peerServer = new PeerServer(5000);
        PeerClient pc = new PeerClient("127.0.0.1", 5000, "/home/marwa/keys.text");
    }

}
