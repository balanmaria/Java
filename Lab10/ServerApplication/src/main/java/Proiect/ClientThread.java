package Proiect;

import Command.Command;
import Command.CommandFactory;
import java.io.*;
import java.net.Socket;

class ClientThread extends Thread {
    private Socket socket = null ;
    public ClientThread (Socket socket) { this.socket = socket ; }
    public void run () {
        while (true) {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();
                String[] args = request.split(" ");
                String endpoint = socket.getInetAddress().getHostName() + ":" + socket.getPort();
                Command command = CommandFactory.getCommmand(args, endpoint, socket.getOutputStream());
                command.execute();
            } catch (IOException e) {
                System.err.println("Communication error... " + e);
            }
        }
    }
}

