package Command;

import Proiect.GameServer;

import java.io.OutputStream;

public class JoinCommand extends Command {
    public JoinCommand(String[] args, String endpoint, OutputStream outputStream) {
        super(args, endpoint, outputStream);
    }

    @Override
    public void execute() {
        GameServer.addSoketMapping(endpoint, args[1]);
        System.out.println(args[1] + "joined in from" + endpoint);
    }

}
