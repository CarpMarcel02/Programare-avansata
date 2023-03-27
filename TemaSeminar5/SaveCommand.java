package org.Seminar5;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SaveCommand implements Command{

    private Catalog catalog;
    private String path;

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public SaveCommand(Catalog catalog, String path) {
        this.catalog = catalog;
        this.path = path;
    }

    /**
     * salvez prin intermediul ObjectMapper-ului catalogul meu cu documente intr-un fisier
     * @throws IOException
     */
    @Override
    public void execute() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(getPath()), getCatalog());
        } catch (IOException e) {
            throw e;
        }
    }
}
