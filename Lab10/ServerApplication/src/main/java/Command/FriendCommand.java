package Command;

import Proiect.GameServer;

import java.io.OutputStream;

public class FriendCommand extends Command {
    public FriendCommand(String[] args, String endpoint, OutputStream outputStream) {
        super(args, endpoint, outputStream);
    }

    @Override
    public void execute() {
        int lenght = args.length;
        for (int i=1; i<lenght; i++){
            GameServer.addFriend(args[i], endpoint);
        }
    }
}
