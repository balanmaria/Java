package Catalog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    public static String getPath;
    private String name;
    private String path;
    private List<Document> documents = new ArrayList<Document>();

    public Catalog(String javaResources, String s) {
        path = s;
        name = javaResources;
    }

    void add(Document doc) {
        documents.add(doc);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }



    public Document findById(String id) {
        for (Document doc : documents) {
            if (doc.getId().equals(id)) {
                return doc;
            }
        }
        return null;
    }
}

