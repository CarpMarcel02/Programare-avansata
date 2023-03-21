package org.example;

import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CatalogUtil {
    /**
     * aici dam save la un anumit catalog intr-un anumit path
     * @param catalog
     * @param path
     * @throws IOException
     */
    public static void save(Catalog catalog, String path) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), catalog);
    }

    /**
     * aici preluam din fisier un anumit catalog
     * @param path
     * @return
     * @throws IOException
     * @throws InvalidCatalogException
     */
    public static Catalog load(String path) throws IOException,InvalidCatalogException{
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(new File(path), Catalog.class);
        return catalog;


    }
}




