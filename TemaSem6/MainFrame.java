import javafx.scene.layout.BorderPane;

public class MainFrame extends BorderPane {

    private boolean start;

    /**
     * creez fiecare panou in partte si le adaug la mainFrame
     */
    public MainFrame() {
        this.start = false;
        CanvasPanel drawingPanel = new CanvasPanel();
        ConfigurationPanel configPanel = new ConfigurationPanel(drawingPanel);
        ControlPanel controlPanel = new ControlPanel(drawingPanel, configPanel);
        this.setTop(configPanel);
        this.setCenter(drawingPanel);
        this.setBottom(controlPanel);
    }


}