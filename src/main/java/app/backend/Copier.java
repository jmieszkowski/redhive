package app.backend;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class Copier {

    static void copyInputStreamToOutputStream(InputStream in, OutputStream out) throws IOException {
        byte[] buf = new byte[8192];
        int len = 0;
        while ((len = in.read(buf)) != -1) {
            out.write(buf, 0, len);
        }
    }
}
