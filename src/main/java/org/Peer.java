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

    //file management
    public void addFile(String filePath) {
        ownedFiles.add(filePath);
        System.out.println("File added: " + filePath);
    }

    public void removeFile(String filePath) {
        ownedFiles.remove(filePath);
        System.out.println("File removed: " + filePath);
    }

    public void listOwnedFiles() {
        System.out.println("Files owned by Peer " + peerID + ":");
        for (String file : ownedFiles) {
            System.out.println("- " + file);
        }
    }

    //peer connection
    public void connectToPeer(Peer peer) {
        connectedPeers.add(peer);
        System.out.println("Connected to peer " + peer.getPeerID());
    }

    public void listConnectedPeers() {
        System.out.println("Connected peers:");
        for (Peer p : connectedPeers) {
            System.out.println("- Peer " + p.getPeerID() + " (" + p.getIp() + ":" + p.getPort() + ")");
        }
    }

    
    public static void main (String[] args){
        PeerServer peerServer = new PeerServer(5000);
        PeerClient pc = new PeerClient("127.0.0.1", 5000, "/home/marwa/keys.text");
    }

}
