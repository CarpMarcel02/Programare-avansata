import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;


public class CanvasPanel extends Pane {
    private Canvas canvas;
    private GraphicsContext gc;
    public Canvas getCanvas() {
        return canvas;
    }
    private int nrBuline;

    /**
     * creez CanvasPanel si ii dau o culoare
     */
    public CanvasPanel()
    {
        this.nrBuline = 0;
        canvas = new Canvas(1000, 880);
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.GRAY);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
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

    /**
     * va afisa pe ecran mesajul cum ca este egalitate
     */
    public void egalitate()
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setTextAlign(TextAlignment.CENTER);
        Font font = Font.font("Arial", FontWeight.BOLD, 80);
        gc.setFont(font);
        gc.setFill(Color.BLACK);
        gc.fillText("Game Over: Egalitate", canvas.getWidth()/2, 80);



    }

    /**
     * Aceasta cu functie va afisa pe ecran faptul ca playerul a castigat
     * @param castigator
     */
    public void playerCastiga(String castigator)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setTextAlign(TextAlignment.CENTER);
        Font font = Font.font("Arial", FontWeight.BOLD, 80);
        gc.setFont(font);
        gc.setFill(Color.BLACK);
        gc.fillText(castigator,canvas.getWidth()/2, 80);

    }

}
