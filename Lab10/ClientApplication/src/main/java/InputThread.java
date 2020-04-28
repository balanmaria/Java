import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class InputThread extends Thread {
    private Socket socket;

    public InputThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
            PrintStream outputStream = new PrintStream(new BufferedOutputStream(this.socket.getOutputStream()), true);

            while(true) {
                String line = inputStreamReader.readLine();
                outputStream.println(line);
            }
        } catch (IOException var11) {
            System.err.println("Communication error... " + var11);
        } finally {
            try {
                this.socket.close();
            } catch (IOException var10) {
                System.err.println(var10);
            }

        }

    }
}