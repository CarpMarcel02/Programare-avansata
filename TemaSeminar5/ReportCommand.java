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