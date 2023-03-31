import javafx.geometry.Insets;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.sun.javafx.application.PlatformImpl.exit;
import static java.lang.Math.sqrt;

public class ConfigurationPanel extends Pane {


    public double[][] matrix = new double[10][4];
    public String conexiune;
    public Button newGameButton;
    public ChoiceBox<String> lineProbChoiceBox;
    public Spinner<Integer> numDotsSpinner;

    public int index;

    ArrayList<ArrayList<Integer>> listaDeAdiacenta1 = new ArrayList<>();

    ArrayList<ArrayList<Integer>> listaDeAdiacenta2 = new ArrayList<>();

    private int numarBuline;

    public ArrayList<ArrayList<Integer>> getListaDeAdiacenta1() {
        return listaDeAdiacenta1;
    }

    public void setListaDeAdiacenta1(ArrayList<ArrayList<Integer>> listaDeAdiacenta1) {
        this.listaDeAdiacenta1 = listaDeAdiacenta1;
    }

    public ArrayList<ArrayList<Integer>> getListaDeAdiacenta2() {
        return listaDeAdiacenta2;
    }

    public void setListaDeAdiacenta2(ArrayList<ArrayList<Integer>> listaDeAdiacenta2) {
        this.listaDeAdiacenta2 = listaDeAdiacenta2;
    }

    private Float sansa;
    private Boolean startJoc;
    private GraphicsContext gc;
    private CanvasPanel canvasPanel;
    public int avemCuloareNeagra;

    private ColorPicker colorPicker;

    public int jocTerminat;


    private Color culoarePlayer1;

    private Color culoarePlayer2;

    public String getConexiune() {
        return conexiune;
    }

    public void setConexiune(String conexiune) {
        this.conexiune = conexiune;
    }

    public Color getCuloarePlayer1() {
        return culoarePlayer1;
    }

    public void setCuloarePlayer1(Color culoarePlayer1) {
        this.culoarePlayer1 = culoarePlayer1;
    }

    public Color getCuloarePlayer2() {
        return culoarePlayer2;
    }

    public void setCuloarePlayer2(Color culoarePlayer2) {
        this.culoarePlayer2 = culoarePlayer2;
    }

    public ColorPicker getColorPicker() {
        return colorPicker;
    }

    public void setColorPicker(ColorPicker colorPicker) {
        this.colorPicker = colorPicker;
    }

    private Color selectedColor;


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

    public List<Line> lines = new ArrayList<>();

    public List<Line> player1 = new ArrayList<>();

    public List<Line> player2 = new ArrayList<>();

    public String traseu1;

    public String traseu2;

    public int amSelectat;
    public int amSelectat2;

    public double coordPrimaBulinaX;
    public double coordPrimaBulinaY;

    public double coordDouaBulinaX;
    public double coordDouaBulinaY;

    public int contorPlayer;

    public int tinutMinte1;

    public int tinutMinte2;


    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * aici se creeaza ConfigurationPanel-ul, se adauga butoanele si le atribue functie fiecaruia, mai intai trebuie setat numarul de buline, si probabilitatea,
     * dupa se apasa newGameButton nu se mai pot schimba
     *
     * @param canvasPanel
     */
    public ConfigurationPanel(CanvasPanel canvasPanel) {

        this.numarBuline = 0;
        this.sansa = 0F;
        this.startJoc = false;
        this.canvasPanel = canvasPanel;

        Label selectColorForBackground = new Label(" Select color for background ");
        ColorPicker colorPicker = new ColorPicker();

        Label numDotsLabel = new Label("Number of dots:");
        Spinner<Integer> numDotsSpinner = new Spinner<>(0, 10, 2);
        Label lineProbLabel = new Label("Line probability:");
        ChoiceBox<Float> lineProbChoiceBox = new ChoiceBox<>();
        lineProbChoiceBox.getItems().addAll(1.0F, 0.9F, 0.8F, 0.7F, 0.6F, 0.5F, 0.4F, 0.3F, 0.2F, 0.1F, 0.0F);
        lineProbChoiceBox.setValue(1.0F);
        Button newGameButton =new Button("Start new game");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(8);
        grid.setHgap(10);

        grid.add(selectColorForBackground, 1, 0);
        grid.add(colorPicker, 2, 0);
        grid.add(numDotsLabel, 5, 0);
        grid.add(numDotsSpinner, 6, 0);
        grid.add(lineProbLabel, 7, 0);
        grid.add(lineProbChoiceBox, 8, 0);
        grid.add(newGameButton, 9, 0);

        colorPicker.setOnAction(event -> {
                    selectedColor = colorPicker.getValue();
                    System.out.println(selectedColor);
                }
        );
        newGameButton.setDefaultButton(false);
        newGameButton.setOnAction(event -> {
            butonDeStart(numDotsSpinner.getValue(), lineProbChoiceBox.getValue());
            newGameButton.setDisable(true);
            lineProbChoiceBox.setDisable(true);
            numDotsSpinner.setDisable(true);
            colorPicker.setDisable(true);

        });

        this.getChildren().add(grid);
    }

    /**
     * aici este practic functia care coloreaza punctele si traseaza liniile dintre puncte, si salveaza acestea intr-o matrice/string in cazul in care se doreste
     * salvarea jocului
     *
     * @param value
     * @param valoare
     */
    public void butonDeStart(Integer value, Float valoare) {
        culoarePlayer1=Color.YELLOW;
        culoarePlayer2=Color.RED;
        jocTerminat=0;
        traseu1= "";
         traseu2="";
        amSelectat = 0;
        amSelectat2 = 0;
        contorPlayer = 0;

        for (int i = 0; i < value; i++) {
            listaDeAdiacenta1.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < value; i++) {
            listaDeAdiacenta2.add(new ArrayList<Integer>());
        }
        setNumarBuline(value);
        double[][] matrice = getMatrix();

        gc = canvasPanel.getCanvas().getGraphicsContext2D();

        gc.setFill(selectedColor);
        gc.fillRect(0, 0, canvasPanel.getWidth() + 50, canvasPanel.getHeight() + 25);

        gc = canvasPanel.getCanvas().getGraphicsContext2D();
        gc.setFill(Color.BLACK);

        double centerX = canvasPanel.getWidth() / 2;
        double centerY = canvasPanel.getHeight() / 2;
        double radius = Math.min(centerX, centerY) * 0.8;

        for (int i = 0; i < value; i++) {
            double angle = i * 2 * Math.PI / value;
            double x = centerX + radius * Math.cos(angle);
            double y = centerY + radius * Math.sin(angle);
            matrice[i][1] = i;
            matrice[i][2] = x;
            matrice[i][3] = y;
            gc.fillOval(x, y, 5, 5);
        }
        Random rand = new Random();
        conexiune = "";
        for (int i = 0; i < value; i++)
            for (int j = 0; j < value; j++)
                if (rand.nextDouble() <= valoare && i != j && i > j) {
                    drawLine(matrice[i][2], matrice[i][3], matrice[j][2], matrice[j][3], Color.BLACK);
                    conexiune = conexiune + i;
                    conexiune = conexiune + j;
                }
        setMatrix(matrice);
        startJoc(canvasPanel);

    }

    /**
     * functie ce preia coordonatele si dupa ce le ia verifica punctele
     * @param canvasPanel
     */
    public void startJoc(CanvasPanel canvasPanel) {

        if(jocTerminat==0) {
        canvasPanel.setOnMouseClicked(event -> {

            double x = event.getX();
            double y = event.getY();
            verificaPunctu(x, y);
        });
    }
    }

    /**
     * Verifica coordonatele dupa apasarea click-ului, mai intai verifica daca unde am apasat este aproape de punctul negru, cauta si al doilea punct disponibil si schimba culoarea
     * @param x
     * @param y
     */
    private void verificaPunctu(double x, double y) {
        if (jocTerminat == 0 && culoarePlayer1!=Color.WHITE && culoarePlayer2!=Color.WHITE)
        {
            double[][] matrice = getMatrix();
            for (int i = 0; i < numarBuline; i++) {
                double distance = sqrt((x - matrice[i][2]) * (x - matrice[i][2]) + (y - matrice[i][3]) * (y - matrice[i][3]));
                if (distance < 10) {
                    if (amSelectat == 0 && x != coordDouaBulinaX && y != coordDouaBulinaY) {
                        coordPrimaBulinaX = matrice[i][2];
                        coordPrimaBulinaY = matrice[i][3];
                        amSelectat = 1;
                        tinutMinte1=i;
                        if (contorPlayer % 2 == 0)
                            traseu1 = traseu1 + i;
                        else
                            traseu2 = traseu2 + i;
                        index = i;

                    } else {
                        double distBetweenSelectedDots = Math.sqrt((x - coordPrimaBulinaX) * (x - coordPrimaBulinaX) + (y - coordPrimaBulinaY) * (y - coordPrimaBulinaY));
                        if (amSelectat == 1 && amSelectat2 == 0 && distBetweenSelectedDots > 10 && amSelectat2 == 0 && coordDouaBulinaX != x && coordDouaBulinaY != y && coordPrimaBulinaX != x && coordPrimaBulinaY != y) {
                            if (contorPlayer % 2 == 0) {
                                listaDeAdiacenta1.get(index).add(i);
                                listaDeAdiacenta1.get(i).add(index);
                                traseu1 = traseu1 + i;


                            } else {
                                listaDeAdiacenta2.get(index).add(i);
                                listaDeAdiacenta2.get(i).add(index);
                                traseu2 = traseu2 + i;

                            }
                            tinutMinte2=i;
                            amSelectat = 0;
                            coordDouaBulinaX = matrice[i][2];
                            coordDouaBulinaY = matrice[i][3];
                            amSelectat2 = 1;
                            contorPlayer++;

                            break;
                        }

                    }
                }
            }
            if (amSelectat2 == 1) {

                if (contorPlayer % 2 == 1) {
                    schimbaCuloarea(culoarePlayer1, coordPrimaBulinaX, coordPrimaBulinaY, coordDouaBulinaX, coordDouaBulinaY);
                    amSelectat2 = 0;
                } else if (contorPlayer % 2 == 0) {
                    schimbaCuloarea(culoarePlayer2, coordPrimaBulinaX, coordPrimaBulinaY, coordDouaBulinaX, coordDouaBulinaY);
                    amSelectat2 = 0;
                }
            }
        }
    }

    /**
     * functia verifica daca linia apasata este de culoare neagra mai intai  si dupa o coloreaza, si verifica daca s-a terminat jocul
     * @param culoare
     * @param coordPrimaBulinaX
     * @param coordPrimaBulinaY
     * @param coordDouaBulinaX
     * @param coordDouaBulinaY
     */
    public void schimbaCuloarea(Color culoare, double coordPrimaBulinaX, double coordPrimaBulinaY, double coordDouaBulinaX, double coordDouaBulinaY) {
        int ok = 0;
        for (Line linie : lines)//intru pe linie neagra
        {
            if ((linie.getStartX() == coordPrimaBulinaX && linie.getStartY() == coordPrimaBulinaY &&
                    linie.getEndX() == coordDouaBulinaX && linie.getEndY() == coordDouaBulinaY) ||
                    (linie.getStartX() == coordDouaBulinaX && linie.getStartY() == coordDouaBulinaY &&
                            linie.getEndX() == coordPrimaBulinaX && linie.getEndY() == coordPrimaBulinaY))
            {
                if (linie.culoare != null && linie.culoare.equals(Color.BLACK))
                {

                    linie.culoare=culoare;
                    ok = 1;
                    break;
                }
            }
        }
        if (ok == 1) {
            drawLine(coordPrimaBulinaX, coordPrimaBulinaY, coordDouaBulinaX, coordDouaBulinaY, culoare);
                if(culoare==culoarePlayer1) {
                    player1.add(new Line(coordPrimaBulinaX, coordPrimaBulinaY, coordDouaBulinaX, coordDouaBulinaY, culoare));
                    verificareCastig(player1);
                    System.out.println(traseu1);
                    }
                else
                    if(culoare==culoarePlayer2)
                    {

                        player2.add(new Line(coordPrimaBulinaX, coordPrimaBulinaY, coordDouaBulinaX, coordDouaBulinaY, culoare ));
                         verificareCastig(player2);
                    }
        }
        else
        {
            contorPlayer--;


            if(contorPlayer%2==0)
            {listaDeAdiacenta1.get(tinutMinte1).remove(Integer.valueOf(tinutMinte2));
                listaDeAdiacenta1.get(tinutMinte2).remove(Integer.valueOf(tinutMinte1));

               traseu1=traseu1.substring(0,traseu1.length()-2);}
            else
            {   listaDeAdiacenta1.get(tinutMinte1).remove(Integer.valueOf(tinutMinte2));
                listaDeAdiacenta1.get(tinutMinte2).remove(Integer.valueOf(tinutMinte1));

                traseu2 = traseu2.substring(0, traseu2.length() - 2);
            }
        }
        avemCuloareNeagra=0;
        for(Line linie : lines)
        {
            if(linie.culoare != null && linie.culoare.equals(Color.BLACK))
                avemCuloareNeagra=1;

        }
        if(avemCuloareNeagra==0)
            canvasPanel.egalitate();

    }

    /**
     * functie ce verifica daca un player a castigat
     * @param player
     */
    public void verificareCastig(List<Line> player)
    {
        for(Line linie : player)
        {
            if(contorPlayer%2==1) {
                for (int u = 0; u <listaDeAdiacenta1.size(); u++) {
                    for (int v : listaDeAdiacenta1.get(u)) {
                        if (listaDeAdiacenta1.get(v).contains(u)) {
                            for (int w : listaDeAdiacenta1.get(v)) {
                                if (listaDeAdiacenta1.get(w).contains(u)) {
                                    canvasPanel.playerCastiga("Player 1 a castigat");
                                    jocTerminat=1;
                                 }
                            }
                        }
                    }
                }
            }
            else {

                for (int u = 0; u <listaDeAdiacenta2.size(); u++) {
                    for (int v : listaDeAdiacenta2.get(u)) {
                        if (listaDeAdiacenta2.get(v).contains(u)) {
                            for (int w : listaDeAdiacenta2.get(v)) {
                                if (listaDeAdiacenta2.get(w).contains(u)) {
                                    canvasPanel.playerCastiga("Player 2 a castigat");
                                    jocTerminat=1;
                                }
                            }
                        }
                    }
                }
                }
            }
        }


    /**
     * functie pentru trasarea unei linii
     *
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     */
    public void drawLine(double startX, double startY, double endX, double endY, Color culoare) {
        gc = canvasPanel.getCanvas().getGraphicsContext2D();
        gc.setStroke(culoare);
        gc.setLineWidth(13);
        gc.strokeLine(startX, startY, endX, endY);
        Line linie = new Line(startX, startY, endX, endY, culoare);
        lines.add(linie);
    }


}
