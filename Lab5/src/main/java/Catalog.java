import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Document> documents = new ArrayList<>();

    Catalog(String javaResources, String s) {
        path=s;
        name=javaResources;
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

    String getPath() {
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
