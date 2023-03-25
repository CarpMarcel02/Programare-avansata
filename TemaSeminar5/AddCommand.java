package org.Seminar5;

public class AddCommand implements Command{

    private Document document;
    private Catalog catalog;

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public AddCommand(Document document, Catalog catalog) {
        this.document = document;
        this.catalog = catalog;
    }

    @Override
    public void execute() {
        catalog.add(document);
    }
}

