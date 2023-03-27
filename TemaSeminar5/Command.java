package org.Seminar5;

import freemarker.template.TemplateException;

import java.io.IOException;

public interface Command {
    void execute() throws IOException, TemplateException;;


}
