package Command;

import Proiect.GameServer;

import java.io.OutputStream;

public class ReadCommand extends Command{
    public ReadCommand(String[] args, String endpoint, OutputStream outputStream){
        super(args, endpoint, outputStream);
    }

    @Override
    public void execute() {
        GameServer.read(endpoint, outputStream);
    }

}
