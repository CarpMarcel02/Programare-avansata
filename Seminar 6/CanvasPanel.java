import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CanvasPanel extends Pane {
    private Canvas canvas;
    private GraphicsContext gc;

    public Canvas getCanvas() {
        return canvas;
    }

    private int nrMaxDeBuline;
    private int nrBuline;

    /**
     * creez CanvasPanel si ii dau o culoare
     */
    public CanvasPanel() {
        // Create the canvas for drawing
        this.nrBuline = 0;
        canvas = new Canvas(1000, 880);

        // Get the graphics context for the canvas
        gc = canvas.getGraphicsContext2D();

        // Set the background color of the canvas
        gc.setFill(Color.GRAY);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // Add the canvas to the pane
        this.getChildren().add(canvas);


    }

    /**
     * a trebuit sa reconstruiesc functtia de reset aici, pur si simplu creez un nou canvas, config si control panel si fac un nou mainFrame si practic repornesc jocul
     * @param canvas
     */
    public void reset(CanvasPanel canvas) {
        CanvasPanel canvasNou = new CanvasPanel();
        ConfigurationPanel configPanel = new ConfigurationPanel(canvasNou);
        ControlPanel controlPanel = new ControlPanel(canvasNou, configPanel);

        MainFrame mainFrame = new MainFrame();
        mainFrame.setBottom(controlPanel);
        mainFrame.setTop(configPanel);
        mainFrame.setCenter(canvasNou);
        Scene scene = new Scene(mainFrame, 1000, 1000);
        Stage stage = (Stage) this.getScene().getWindow();
        stage.setScene(scene);
    }

    public GraphicsContext getGraphicsContext() {
        return gc;
    }


}
