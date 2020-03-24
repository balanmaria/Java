package shell;

import Catalog.Exception.InvalidDefinitionFormatException;
import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.org.apache.xml.internal.resolver.Catalog;

import java.io.IOException;

public class AddCommand extends shell.Command {
    public AddCommand(Catalog catalog) {
        super(catalog);
    }

    public void execute(String[] args) throws IOException, InvalidDefinitionFormatException {
        this.catalog.add(args[0]);
    }
}
