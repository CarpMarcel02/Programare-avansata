package org.Seminar5;

import java.io.IOException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class Main {
    public static void main(String args[]) throws InvalidCatalogException, IOException {
        Main app = new Main();
        try
        {
        app.testCreateSave();
        app.testLoadView();
        app.testReport();
        }
        catch ( InvalidCatalogException | IOException e)
        {
            e.printStackTrace();
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }


    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("MyDocuments");

        var book = new Document("carte", "Capra cu trei iezi");
        var article = new Document("articol", "BZI");
        var carte=new Document("carte","Fram Ursu Polar ");
        var carte2=new Document("carte1","Cei trei muschetari ");

        catalog.add(book);
        catalog.add(article);
        catalog.add(carte);
        catalog.add(carte2);

        SaveCommand saveCommand = new SaveCommand(catalog,"g:/research/catalog1.json");
        try {
            saveCommand.execute();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Nu s-a putut ajunge la catalog");
        }
    }

    private void testLoadView() throws IOException, InvalidCatalogException {
        Catalog catalogNou= new Catalog("catalogloaded");
        LoadCommand loadCommand =new LoadCommand(catalogNou,"g:/research/catalog1.json");
        loadCommand.execute();
        ListCommand lista = new ListCommand(catalogNou);
        //lista.execute();
        ViewCommand vizualizare = new ViewCommand("g:/researchtext/Balene.txt");
        //vizualizare.execute();(imi va deschide fisierul text balena)

    }

    private void testReport() throws IOException, TemplateException {
       try{
        Catalog catalog= new Catalog("catalogation");
        var book = new Document("carte", "Capra cu trei iezi");
        var article = new Document("articol", "BZI");
        var carte=new Document("carte","Fram Ursu Polar ");
        var carte2=new Document("carte1","Cei trei muschetari ");
        catalog.add(book);
        catalog.add(article);
        catalog.add(carte);
        catalog.add(carte2);


           String reportPath = "g:/TemaJava/Sem4/Seminar5/src/main/resources/templates/report.html";
           ReportCommand reportCommand = new ReportCommand(catalog, reportPath);

           // Execute the ReportCommand
           reportCommand.execute();


    } catch (IOException e) {
        System.err.println("An error occurred: " + e.getMessage());
    }

    }
}









