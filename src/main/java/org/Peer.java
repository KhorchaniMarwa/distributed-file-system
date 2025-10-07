package org;

import java.util.ArrayList;
import java.util.List;

public class Peer {
    private int peerID;
    private String IP;
    private int port;
    private ArrayList<String> ownedFiles;
    private List<Peer> connectedPeers;


    public  Peer(int peerID,int port,String IP, ArrayList<String> ownedFiles, List<Peer> connectedPeers){
        this.peerID = peerID;
        this.port = port;
        this.IP = IP;
        this.ownedFiles = new ArrayList<>();
        this.connectedPeers = new ArrayList<>();
    }

    //getters
    public int getPeerID() {
        return peerID;
    }

    public String getIp() {
        return IP;
    }

    public int getPort() {
        return port;
    }


    public static void main (String[] args){
        PeerServer peerServer = new PeerServer(5000);
        PeerClient pc = new PeerClient("127.0.0.1", 5000, "/home/marwa/keys.text");
    }

}
