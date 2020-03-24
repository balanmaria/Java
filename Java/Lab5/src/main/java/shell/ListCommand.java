package shell;

import com.sun.org.apache.xml.internal.resolver.Catalog;

public class ListCommand extends shell.Command {
    public ListCommand(Catalog catalog) {
        super(catalog);
    }

    public void execute(String[] args) {
        this.catalog.list();
    }
}