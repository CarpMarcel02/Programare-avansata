package org.Seminar5;
import java.util.*;

public class ListCommand implements Command {
    private final Catalog catalog;

    public ListCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    /**
     * functia ia dintr-un catalog toate documentele si le afiseaza
     */
    @Override
    public void execute() {
        List<Document> documents = catalog.getDocs();
        if (documents.isEmpty()) {
            throw new CatalogIsEmptyException("The catalog is empty.");
        }
        for (Document document : documents) {
            System.out.println(document);
        }
    }

    /**
     * exceptie ce apare in cazul in care catalogul este gol
     */
    public static class CatalogIsEmptyException extends RuntimeException {
        public CatalogIsEmptyException(String message) {
            super(message);
        }
    }
}