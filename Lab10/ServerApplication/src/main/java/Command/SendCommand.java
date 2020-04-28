package Command;

import Proiect.GameServer;

import java.io.OutputStream;

public class SendCommand extends Command {
    public SendCommand (String[] args, String endpoint, OutputStream outputStream){
        super(args, endpoint, outputStream);
    }

    @Override
    public void execute() {
        GameServer.sendMassage(endpoint, args[1]);
    }
}
