package shell;

import com.sun.org.apache.xml.internal.resolver.Catalog;
import Catalog.CatalogUtil;

public class ExitCommand extends Command {
    public ExitCommand(CatalogUtil catalogIO) {
        super(catalogIO);
    }

    public ExitCommand(Catalog catalog) {
        super(catalog);
    }

    public void execute(String[] args) {
        System.out.println("Bye!");
        System.exit(0);
    }
}
