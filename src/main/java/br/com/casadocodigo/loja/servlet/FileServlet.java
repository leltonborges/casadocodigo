package br.com.casadocodigo.loja.servlet;

import br.com.casadocodigo.loja.infra.FileSave;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet("/file/*")
public class FileServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String relativePath = req.getRequestURI().split("/file")[1];

        Path source = Paths.get(FileSave.SERVER_PATH + relativePath);
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        String contentType = fileNameMap.getContentTypeFor("file:" + source);

        resp.reset();
        resp.setContentType(contentType);
        resp.setHeader("Content-Length", String.valueOf(Files.size(source)));
        resp.setHeader("Content-Disposition", "filename=\""
                + source.getFileName().toString() + "\"");

        FileSave.transfer(source, resp.getOutputStream());

    }
}
