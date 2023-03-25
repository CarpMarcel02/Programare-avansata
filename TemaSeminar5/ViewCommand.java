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

    @Override
    public void execute() throws IOException {
        File file = new File(getPath());
        Desktop desktop = Desktop.getDesktop();
        desktop.open(file);
    }
}
