import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int PORT = 8100;
    private static PrintWriter fout = null;
    private static BufferedReader fin = null;

    public GameClient() {
    }

    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1";
        short PORT = 8100;

        try {
            Socket socket = new Socket(serverAddress, PORT);
            Throwable var4 = null;

            try {
                (new InputThread(socket)).run();
                (new OutputThread(socket)).run();
            } catch (Throwable var14) {
                var4 = var14;
                try {
                    throw var14;
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            } finally {
                if (socket != null) {
                    if (var4 != null) {
                        try {
                            socket.close();
                        } catch (Throwable var13) {
                            var4.addSuppressed(var13);
                        }
                    } else {
                        socket.close();
                    }
                }

            }
        } catch (UnknownHostException var16) {
            System.err.println("No server listening... " + var16);
        }

    }

}
