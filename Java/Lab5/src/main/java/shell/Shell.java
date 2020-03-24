package shell;

import Catalog.Exception.CommandNotFoundException;
import Catalog.Exception.CouldNotDeserializeDefinitionException;
import Catalog.Exception.InvalidDefinitionFormatException;
import com.sun.org.apache.xml.internal.resolver.Catalog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import Catalog.CatalogUtil;

public class Shell {
    private Map<String, Command> commandMapping = new HashMap();

    public Shell(Catalog catalog) {
        this.commandMapping.put("list", new ListCommand(catalog));
        this.commandMapping.put("add", new AddCommand(catalog));
        this.commandMapping.put("load", new LoadCommand(catalog));
        this.commandMapping.put("save", new SaveCommand(catalog));
        this.commandMapping.put("exit", new ExitCommand(catalog));
    }

    public Shell(CatalogUtil catalogUtil) {
        this.commandMapping.put("load", new LoadCommand(catalogUtil));
        this.commandMapping.put("save", new SaveCommand(catalogUtil));
        this.commandMapping.put("exit", new ExitCommand(catalogUtil));
    }

    private void process(String line) {
        String commandName = line;
        String[] args;
        if(line.contains(" ")) {
            commandName = line.substring(0, line.indexOf(" "));
            args = line.substring(line.indexOf(" ") + 1).split(", ");
        } else {
            args = new String[0]; //args nu are voie sa fie null niciodata , altfel da null pointerexception
            //de aceea ii punem un string empty
        }

        for(int i = 0; i < args.length; ++i) {
            args[i] = args[i].replaceAll("\"", "");
        }

        try {
            if(!this.commandMapping.containsKey(commandName)) {
                throw new CommandNotFoundException();
            }

            ((Command)this.commandMapping.get(commandName)).execute(args);

        } catch (IOException var5) {
            System.out.println("Error accessing file: " + var5.getMessage());
        } catch (InvalidDefinitionFormatException var6) {
            System.out.println("Invalid definition format!");
        } catch (IndexOutOfBoundsException var7) {
            System.out.println("Insufficient number of arguments provided!");
        } catch (CouldNotDeserializeDefinitionException var8) {
            System.out.println("Could not load from file");
        } catch (Exception var9) {
            System.out.println("Other catalog.exception occurred: " + var9.getMessage());
        }

    }

    public void start() throws IOException {
        BufferedReader stream = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Started shell. Input commands below: ");

        while(true) {
            System.out.print("> ");
            String line = stream.readLine();
            this.process(line);
        }
    }
}