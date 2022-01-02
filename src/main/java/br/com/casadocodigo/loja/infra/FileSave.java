package br.com.casadocodigo.loja.infra;

import javax.servlet.http.Part;
import java.io.IOException;

public class FileSave {


    private static final String SERVER_PATH = "/opt/casadocodigo";
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
                    relativePath.replaceFirst("/", ""):
                    relativePath;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
