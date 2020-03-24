package shell;

import Catalog.Exception.CouldNotDeserializeDefinitionException;
import com.sun.org.apache.xml.internal.resolver.Catalog;

import java.io.IOException;
import Catalog.CatalogUtil;

public class LoadCommand extends shell.Command {
    public LoadCommand(Catalog catalog) {
        super(catalog);
    }

    public LoadCommand(CatalogUtil catalog) {
        super(catalog);
    }

    public void execute(String[] args) throws IOException, CouldNotDeserializeDefinitionException {
        this.catalog.load(args[0]);
        System.out.println("Successfully loaded from file");
    }
}
