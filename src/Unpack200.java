import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.jar.JarOutputStream;
import java.util.jar.Pack200;

public class Unpack200 {
    public static void main(final String[] args) throws IOException {
        final Pack200.Unpacker unpacker = Pack200.newUnpacker();
        final String packFilename;
        final String jarFilename;
        if (args.length == 1) {
            packFilename = args[0];
            jarFilename = packFilename.toLowerCase().endsWith(".pack") ?
                    packFilename.substring(0, packFilename.length() - ".pack".length()) + ".jar" :
                    packFilename + ".jar";
        } else if (args.length == 2) {
            packFilename = args[0];
            jarFilename = args[1];
        } else {
            System.out.println("Usage: \"Unpack200 file.pack\" OR \"Unpack200 file.pack file.jar\"");
            System.exit(1);
            return;
        }
        final File packFile = new File(packFilename);
        final InputStream in = new BufferedInputStream(new FileInputStream(packFile));
        final OutputStream out = new BufferedOutputStream(new FileOutputStream(jarFilename));
        try {
            final JarOutputStream jarOutputStream = new JarOutputStream(out);
            unpacker.unpack(in, jarOutputStream);
            jarOutputStream.finish();
        } finally {
            in.close();
            out.close();
        }
    }

}
