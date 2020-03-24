package Catalog.Exception;

public class CommandNotFoundException extends Exception {
    public CommandNotFoundException() {
        super("Command not found");
    }
}
