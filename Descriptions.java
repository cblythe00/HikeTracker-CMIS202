import java.util.Hashtable;

public class Descriptions extends Trail {

    Hashtable<String, String> table;
    public Descriptions() {
        table = new Hashtable<>();
    }

    public void addDescription(String key, String value) {
        table.put(key, value);
    }
    public String getDescription(String key) {
        return table.get(key);
    }
}
