package org.Seminar5;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class LoadCommand implements Command{


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

    public LoadCommand(Catalog catalog, String path) {
        this.catalog = catalog;
        this.path = path;
    }

    /**
     * functia ia dintr-un path un catalog si il stocheaza intr-un objectMapper prin JSON
     * @throws IOException
     */
    @Override
        public void execute() throws IOException {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                catalog.setDocs(objectMapper.readValue(new File(getPath()), Catalog.class).getDocs());
            } catch (IOException e) {
                throw e;
            }

        }
        }
