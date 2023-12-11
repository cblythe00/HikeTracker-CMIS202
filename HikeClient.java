import javafx.scene.control.ComboBox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.LinkedList;

public class HikeClient {

    private DataOutputStream toServer = null;
    private DataInputStream fromServer = null;

    public void client(ComboBox<String> cb, Trail trail) {

        LinkedList<String> list = new LinkedList<>(trail.getList());
        String name = cb.getValue().trim();
        String fullHike = "No hike found.";

        try {
            for (String s : trail.getList()) {

                int i = list.indexOf(s);
                s = s.trim().replaceAll("\\$", " ");

                if (s.equals(name)) {

                    fullHike = "Name: " + s + "\n Distance: " + list.get(i + 1).replaceAll("\\$", " ") +
                            "\n Elevation: " + list.get(i + 2).replaceAll("\\$", " ") + "\n Location: " +
                            list.get(i + 3).replaceAll("\\$", " ");

                    break;
                }
            }
            toServer.writeChars(fullHike);
            toServer.flush();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
