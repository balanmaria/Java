package shell;


import com.sun.org.apache.xml.internal.resolver.Catalog;
import Catalog.CatalogUtil;

public abstract class Command {
    protected Catalog catalog;
    protected CatalogUtil catalogUtil;

    public Command(CatalogUtil catalogUtill) {this.catalogUtil=catalogUtill;}

    public Command(Catalog catalog1) {this.catalog=catalog1;}

    public abstract void execute(String[] var1) throws Exception;
}
