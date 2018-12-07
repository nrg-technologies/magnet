import java.util.*;
import java.security.*;

public class Signature {

    private final String key;
    private final List<Object> list;
    
    public Signature(String key) {
        this.key = key;
        this.list = new ArrayList();
    }

    public Signature addParameter(
            Object parameter
            ) {
        list.add(parameter);
        return this;
    }

    public Signature setQueryString(
            String string
            ) {
        for(String pair : string.split("&")) {
            list.add(pair.split("=")[1]);
        }
        // Remove signature itself
        list.remove(
                list.size() - 1
                );
        return this;
    }

    public void clear() {
        list.clear();
    }

    public String generate()
            throws NoSuchAlgorithmException {
            MessageDigest m =
                    MessageDigest.getInstance("MD5");
            m.reset();
            StringBuilder builder = new StringBuilder();
            for(Object item : list) {
                builder.append(item);
            }
            m.update(String.format(
                    "%s%s",
                    builder.toString(),
                    key
                    ).getBytes());
            byte[] digest = m.digest();
            return Base64.getEncoder().encodeToString(digest);
    }
}
