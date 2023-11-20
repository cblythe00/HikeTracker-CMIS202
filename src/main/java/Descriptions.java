import java.util.TreeMap;

public class Descriptions extends Trail {

    private TreeMap<String, String> map;

    public Descriptions() {

        map = new TreeMap<>();
    }

    public void addDescription(String key, String value) {

        map.put(key.trim().replaceAll(" ", ""), value);
    }

    public void addDescription(Trail t, String value) {

        addDescription(t.getTrailName().trim().replaceAll(" ", ""), value);
    }
}
