package Command;

import Proiect.GameServer;

import java.io.OutputStream;

public class RegisterCommand extends Command {
    public RegisterCommand (String[] args, String endpoint, OutputStream outputStream) {
        super(args, endpoint, outputStream);
    }

    @Override
    public void execute() {
        GameServer.registerPlayer(args[1]);
        System.out.println(args[1] + " has registred! ");
    }

}
