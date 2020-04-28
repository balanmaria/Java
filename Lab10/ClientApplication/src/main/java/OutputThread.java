import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class OutputThread extends Thread {
    private Socket socket;

    public OutputThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

            while(true) {
                String line = in.readLine();
                System.out.println(line);
            }
        } catch (IOException var3) {
            System.out.println("Some error occured.");
        }
    }
}