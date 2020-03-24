package shell;

import com.sun.org.apache.xml.internal.resolver.Catalog;

import java.io.IOException;
import Catalog.CatalogUtil;

public class SaveCommand extends shell.Command {
    public SaveCommand(Catalog catalog) {
        super(catalog);
    }

    public SaveCommand(CatalogUtil catalogUtil) {
        super(catalogUtil);
    }

    public void execute(String[] args) throws IOException {
        this.catalogUtil.save(args[0]);
        System.out.println("Successfully saved to " + args[0]);
    }
}