package org.example;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws InvalidCatalogException, IOException {
        Main app = new Main();
        try
        {
        app.testCreateSave();
        app.testLoadView();
        }
        catch ( InvalidCatalogException | IOException e)
        {
            e.printStackTrace();
        }
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("MyDocuments");

        var book = new Document("carte", "Capra cu trei iezi");
        var article = new Document("articol", "BZI");

        catalog.add(book);
        catalog.add(article);


        CatalogUtil.save(catalog,"g:/research/catalog1.json");
    }

    private void testLoadView() throws IOException, InvalidCatalogException {
        Catalog catalog = CatalogUtil.load("g:/research/catalog1.json");

    }
}









