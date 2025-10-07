package org;

import java.util.ArrayList;
import java.util.List;

public class Peer {
        private int peerID;
        private String ip;
        private int port;
        private List<String> ownedFiles;
        private List<Peer> connectedPeers;

        public Peer(int peerID, String ip, int port) {
            this.peerID = peerID;
            this.ip = ip;
            this.port = port;
            this.ownedFiles = new ArrayList<>();
            this.connectedPeers = new ArrayList<>();
        }
        //getters
        public int getPeerID() {
            return peerID;
        }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }
    
    public static void main (String[] args){
        PeerServer peerServer = new PeerServer(5000);
        PeerClient pc = new PeerClient("127.0.0.1", 5000, "/home/marwa/keys.text");
    }

}
