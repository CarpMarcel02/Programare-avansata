import javafx.geometry.Insets;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


import java.awt.*;
import java.util.Random;

public class ConfigurationPanel extends Pane {


    public double[][] matrix = new double[10][4];
    public String conexiune;
    public Button newGameButton;
    public ChoiceBox<String> lineProbChoiceBox;
    public Spinner<Integer> numDotsSpinner;
    private int numarBuline;
    private Float sansa;
    private Boolean startJoc;
    private GraphicsContext gc;
    private CanvasPanel canvasPanel;

    /**
     * aici se creeaza ConfigurationPanel-ul, se adauga butoanele si le atribue functie fiecaruia, mai intai trebuie setat numarul de buline, si probabilitatea,
     * dupa se apasa newGameButton nu se mai pot schimba
     * @param canvasPanel
     */
    public ConfigurationPanel(CanvasPanel canvasPanel) {
        this.numarBuline = 0;
        this.sansa = 0F;
        this.startJoc = false;
        this.canvasPanel = canvasPanel;

        // Create the UI components for the configuration panel
        Label numDotsLabel = new Label("Number of dots:");
        Spinner<Integer> numDotsSpinner = new Spinner<>(0, 10, 2);
        Label lineProbLabel = new Label("Line probability:");
        ChoiceBox<Float> lineProbChoiceBox = new ChoiceBox<>();
        lineProbChoiceBox.getItems().addAll(1.0F,0.9F,0.8F,0.7F,0.6F,0.5F,0.4F,0.3F,0.2F,0.1F,0.0F);
        lineProbChoiceBox.setValue(1.0F);
        Button newGameButton = new Button("Create new game");

        // Add the UI components to a grid pane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.add(numDotsLabel, 22, 0);
        grid.add(numDotsSpinner, 23, 0);
        grid.add(lineProbLabel, 24, 0);
        grid.add(lineProbChoiceBox, 25, 0);
        grid.add(newGameButton, 26, 0);

        newGameButton.setDefaultButton(false);
        newGameButton.setOnAction(event ->{
            butonDeStart(numDotsSpinner.getValue(),lineProbChoiceBox.getValue());
            newGameButton.setDisable(true);
            lineProbChoiceBox.setDisable(true);
            numDotsSpinner.setDisable(true);
        });

        // Add the grid pane to this panel
        this.getChildren().add(grid);
    }

    public int getNumarBuline() {
        return numarBuline;
    }

    public void setNumarBuline(int numarBuline) {
        this.numarBuline = numarBuline;
    }

    public Float getSansa() {
        return sansa;
    }

    public void setSansa(Float sansa) {
        this.sansa = sansa;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * functie ce dezactiveaza butoanele dupa inceperea jocului
     */
    public void dezactiveazaButoanele()
    {
        newGameButton.setDisable(true);
        lineProbChoiceBox.setDisable(true);
        numDotsSpinner.setDisable(true);
    }

    /**
     * aici este practic functia care coloreaza puncteele si traseaza liniile dintre puncte, si salveaza acestea intr-o matrice/string in cazul in care se doreste
     * salvarea jocului
     * @param value
     * @param valoare
     */
    private void butonDeStart(Integer value, Float valoare) {


        double[][] matrice = getMatrix();
        setStartJoc(true);

        gc = canvasPanel.getCanvas().getGraphicsContext2D();
        gc.setFill(Color.BLACK);

        double centerX = canvasPanel.getWidth() / 2;
        double centerY = canvasPanel.getHeight() / 2;
        double radius = Math.min(centerX, centerY) * 0.8;

        for (int i = 0; i < value; i++) {
            double angle = i * 2 * Math.PI / value;
            double x = centerX + radius * Math.cos(angle);
            double y = centerY + radius * Math.sin(angle);
            matrice[i][1]=i;
            matrice[i][2]=x;
            matrice[i][3]=y;
            gc.fillOval(x, y, 5, 5);
        }
        Random rand = new Random();
        conexiune="";
        for(int i=0;  i< value;i++)
            for(int j=0; j<value;j++)
            if (rand.nextDouble() <= valoare && i!=j && i>j)
            {
                drawLine(matrice[i][2],matrice[i][3],matrice[j][2],matrice[j][3]);
                conexiune=conexiune+i;
                conexiune=conexiune+j;
            }
        for(int i=0;  i< value;i++)
            System.out.println(matrice[i][1]+ " "+ matrice[i][2] + " " + matrice[i][3]);


    }

    /**
     * functie pentru trasarea unei linii
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     */
    public void drawLine(double startX, double startY, double endX, double endY) {
        gc = canvasPanel.getCanvas().getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeLine(startX, startY, endX, endY);
    }
    public Boolean getStartJoc() {
        return startJoc;
    }

    public void setStartJoc(Boolean startJoc) {
        this.startJoc = startJoc;
    }

    /**
     * in cazul in care se doreste resetarea jocului, permite selectarea din nou a numarului de buline si a sansei
     */
    public void resetare()
    {
        this.numarBuline = 0;
        this.sansa = 0F;
        this.startJoc = false;
    }


}
