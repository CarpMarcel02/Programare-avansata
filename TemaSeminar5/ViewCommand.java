package org.Seminar5;

import java.io.IOException;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements Command {

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ViewCommand(String path) {
        this.path = path;
    }

    /**
     * aceastta functie imi va deschide un fisier dintr-un anumit path
     * @throws IOException
     */
    @Override
    public void execute() throws IOException {
        File file = new File(getPath());
        if (!file.exists()) {
            throw new FileNotFoundException("The file " + getPath() + " does not exist.");
        }
        Desktop desktop = Desktop.getDesktop();
        desktop.open(file);
    }

    public static class FileNotFoundException extends IOException {
        public FileNotFoundException(String message) {
            super(message);
        }
    }
}