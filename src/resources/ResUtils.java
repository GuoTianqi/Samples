package resources;

import java.io.InputStream;

public class ResUtils {
    public static InputStream getImageAsStream(String name) {
        return ResUtils.class.getResourceAsStream("images/" + name);
    }
}
