package Command;

import java.io.OutputStream;

public abstract class Command {
    protected String[] args;
    protected String endpoint;
    protected OutputStream outputStream;

    public Command(String[] args, String endpoint, OutputStream outputStream) {
        this.args = args;
        this.endpoint = endpoint;
        this.outputStream = outputStream;
    }

    public String[] getArgs() {
        return args;
    }

    public abstract void execute();
}
