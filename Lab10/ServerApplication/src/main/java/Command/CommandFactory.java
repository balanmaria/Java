package Command;

import Proiect.GameServer;

import java.io.OutputStream;

public class CommandFactory {
    public static Command getCommmand(String[] args, String endpoint, OutputStream outputStream){
        switch (args[0]){
            case "register":
                return new RegisterCommand(args, endpoint, outputStream);
            case "friend":
                return new FriendCommand(args, endpoint, outputStream);
            case "join":
                return new JoinCommand(args, endpoint, outputStream);
            case "send" :
                return new SendCommand(args, endpoint, outputStream);
            case "read":
                return new ReadCommand(args, endpoint, outputStream);
            //case "stop":
                //return new StopCommand(args, endpoint, outputStream);
            default:
                return null;
        }
    }
}
