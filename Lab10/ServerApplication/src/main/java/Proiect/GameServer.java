package Proiect;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class GameServer {
    private static final int PORT = 8100;
    private ServerSocket serverSocket;
    private boolean running = false;
    private static Map<String, String> socketMapping = new HashMap<String, String>();
    private static List<Player> players = new ArrayList<Player>();

    public GameServer() {

    }

    public static void main(String[] args) {
        GameServer server = new GameServer();
        server.init();
        server.waitForClients();
    }

    private void init() {
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            System.out.println("Could not start server: " + e.getMessage());
        }
        running = true;
    }

    private void waitForClients() {
        while (running) {
            System.out.println("Waiting the client... ");

            Socket socket = null;
            try {
                socket = serverSocket.accept();
                (new ClientThread(socket)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //functionalitatile jocului

    private static Player getPlayerByName(String username){
        for (Player player: players) {
            if (player.getPlayer().equals(username))
                return player;
        }
        return null;
    }

    public static void addSoketMapping(String endpoint, String username){
        socketMapping.put(endpoint, username);
    }

    public static void registerPlayer(String username) {
        Player newPlayer = new Player(username);
        players.add(newPlayer);
    }

    public static void addFriend (String nameFriend, String endpoint){
        String clientPlayerName = socketMapping.get(endpoint);
        Player clientPlayer = getPlayerByName(clientPlayerName);
        clientPlayer.getFriends().add(nameFriend);
    }

    public static void sendMassage(String endpoint, String message){
        String clientName= socketMapping.get(endpoint);
        Player clientUser = getPlayerByName(clientName);
        for(String friend : clientUser.getFriends()){
            getPlayerByName(friend).getMessages().add(clientName + ": " + message);
        }
    }

    public static void read (String endpoint, OutputStream outputStream){
        String clientName = socketMapping.get(endpoint);
        Player clientUser = getPlayerByName(clientName);
        PrintStream bufferedOutputStream = new PrintStream(new BufferedOutputStream(outputStream));
        for (String message : clientUser.getMessages()){
            bufferedOutputStream.println(message);
        }
    }

    public void stop() throws Exception {
        running = false;
        serverSocket.close();
    }

}
