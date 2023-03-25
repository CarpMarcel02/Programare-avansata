package org.Seminar5;
import java.util.*;

public class ListCommand implements Command {
    private final Catalog catalog;

    public ListCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute() {
        List<Document> documents = catalog.getDocs();
        for (Document document : documents) {
            System.out.println(document);
        }
    }
}