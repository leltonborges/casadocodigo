package br.com.casadocodigo.loja.infra;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Part;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Path;

public class FileSave {
    public static final String SERVER_PATH = "/opt/casadocodigo";
    private String relativePath;

    public String writerPath(Part file, String path) {
        try {
            if (path.endsWith("/")) {
                this.relativePath = path + file.getSubmittedFileName();
                file.write(SERVER_PATH + relativePath);
            } else {
                this.relativePath = path + "/" + file.getSubmittedFileName();
                file.write(SERVER_PATH + "/" + relativePath);
            }

            return relativePath.startsWith("/") ?
                    relativePath.replaceFirst("/", "") :
                    relativePath;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void transfer(Path source, OutputStream outputStream) {
        try {
            FileInputStream fileInputStream = new FileInputStream(source.toFile());

            try (ReadableByteChannel channel = Channels.newChannel(fileInputStream);
                WritableByteChannel outputChannel = Channels.newChannel(outputStream)) {
                ByteBuffer buffer = ByteBuffer.allocateDirect(1024*10);

                while (channel.read(buffer) != -1){
                    buffer.flip();
                    outputChannel.write(buffer);
                    buffer.clear();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
