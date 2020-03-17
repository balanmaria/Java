import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document implements Serializable {
   private String location;
   private String name;
   private String id;

   private Map<String, Object> tags = new HashMap<String, Object>();

    public Document(String java1, String s, String s1) {
       id=java1;
        name=s;
        location=s1;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }
}
