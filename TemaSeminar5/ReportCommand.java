package org.Seminar5;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class ReportCommand implements Command {

    private Catalog catalog;
    private String path;

    public ReportCommand(Catalog catalog, String path) {
        this.catalog = catalog;
        this.path = path;
    }

    /**
     * functia creeaza un raport HTML pe baza obiectelor din catalog si il salveaza intr-un fisier dupa prin ajutorul functiei Desktop.getDesktop va deschide acel fisier intr-un site
     * @throws IOException
     * @throws TemplateException
     */
    @Override
    public void execute() throws IOException, TemplateException {
        List<Document> documents = catalog.getDocs();
        String htmlReport = TemplateProcessor.createHtmlReport(documents);
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(htmlReport);
        fileWriter.close();
        Desktop.getDesktop().browse(new File(path).toURI());
    }




public class TemplateProcessor {

    private static final String TEMPLATE_DIR = "src/main/resources/templates";

    /**
     * creez o configuratie pentru FreeMarker, care imi incarca sabloanele HTML, setez directorul, ii arat ce sablon sa foloseasca, prin
     * map ii arat ce documente din catalog sa puna in html si le scrie
     * @param documents
     * @return
     * @throws IOException
     * @throws TemplateException
     */
    public static String createHtmlReport(List<Document> documents) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setDirectoryForTemplateLoading(new File(TEMPLATE_DIR));
        cfg.setDefaultEncoding("UTF-8");
        Template template = cfg.getTemplate("report.ftl");
        Map<String, Object> data = new HashMap<>();
        data.put("documents", documents);
        StringWriter out = new StringWriter();
        template.process(data, out);
        return out.getBuffer().toString();
    }

}}