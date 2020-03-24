package Catalog;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import Catalog.Catalog;

public class CatalogUtil {
    public static void save(String catalog)
            throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Catalog.getPath))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path) throws InvalidCatalogException {
        Catalog catalog=null;
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            assert objectInputStream != null;
            catalog = (Catalog) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return catalog;
    }

    public static void view(Document doc) {
        if(doc.getLocation().startsWith("http")){
            URI uri = null;
            try {
                uri = new URI("www.google.com");
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            Desktop dt = Desktop.getDesktop();
            try {
                dt.browse(uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            File file = new File(doc.getLocation());
            try {
                Desktop desktop = Desktop.getDesktop();
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class InvalidCatalogException extends Exception {
        public InvalidCatalogException(Exception ex) {
            super("Invalid catalog file.", ex);
        }
    }

}