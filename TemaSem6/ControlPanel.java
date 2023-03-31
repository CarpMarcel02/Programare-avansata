import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


/**
 * se creeaza ControlPanel-ul
 */
public class ControlPanel extends Pane {

    private CanvasPanel canvasPanel;

    public CanvasPanel getCanvasPanel() {
        return canvasPanel;
    }

    public ConfigurationPanel getConfigurationPanel() {
        return configurationPanel;
    }

    private ConfigurationPanel configurationPanel;

    /**
     * adaug butoanele save, load,reset, exit, butoane pentru selectarea culorii pentru fiecare player, atasarea lor in aplicatie, si atribuirea de activitati la apasarea lor
     *
     * @param canvasPanel
     * @param configurationPanel
     */
    public ControlPanel(CanvasPanel canvasPanel, ConfigurationPanel configurationPanel) {
        // Create the UI components for the control panel
        this.configurationPanel = configurationPanel;
        this.canvasPanel = canvasPanel;
        Button loadButton = new Button("Load");
        Button saveButton = new Button("Save");
        Button resetButton = new Button("Reset");
        Button exitButton = new Button("Exit");
        Label selectPlayer1 = new Label(" Select color for player 1 ");
        Label selectPlayer2 = new Label(" Select color for player 2 ");

        ColorPicker culoarePlayer1 = new ColorPicker();
        ColorPicker culoarePlayer2 = new ColorPicker();
        culoarePlayer1.setValue(Color.YELLOW);
        culoarePlayer2.setValue(Color.RED);

        // Add the UI components to a grid pane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.add(loadButton, 15, 0);
        grid.add(saveButton, 16, 0);
        grid.add(resetButton, 17, 0);
        grid.add(exitButton, 18, 0);


        grid.add(selectPlayer1, 0, 0);
        grid.add(selectPlayer2, 28, 0);
        grid.add(culoarePlayer1, 1, 0);
        grid.add(culoarePlayer2, 29, 0);


        culoarePlayer1.setOnAction(event -> {
            Color colorPlayer1 = culoarePlayer1.getValue();
            configurationPanel.setCuloarePlayer1(colorPlayer1);
        });
        culoarePlayer2.setOnAction(event -> {
            Color colorPlayer2 = culoarePlayer2.getValue();
            configurationPanel.setCuloarePlayer2(colorPlayer2);
        });


        resetButton.setOnAction(event -> {
                    canvasPanel.reset(canvasPanel);
                    configurationPanel.jocTerminat = 0;
                }
        );


        exitButton.setOnAction(event -> Platform.exit());
        saveButton.setOnAction(event -> {
            salveaza();
        });
        loadButton.setOnAction(event -> {
                    try {
                        uploadeaza();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        this.getChildren().add(grid);
    }

    /**
     * functia salveaza pur si simplu parcurge matricea de puncte cu tot cu coordonatele ei si o salveaza pe desktop intr-un fisier,
     * traseul pentru fiecare player ce reprezinta nodurile pe care le parcurge, si contorPlayer ce reprezinta randul player-ului, ca sa tina minte la ce player a ramas
     */
    public void salveaza() {
        String desktopPath = System.getProperty("user.home") + "/Desktop/";
        try (PrintWriter writer = new PrintWriter(new FileWriter(desktopPath + "Copie1.txt"))) {
            writer.println(configurationPanel.getNumarBuline());
            for (double[] row : configurationPanel.matrix) {
                for (int i = 1; i < row.length; i++) {
                    writer.print(row[i]);
                    if (i < row.length - 1) {
                        writer.print(",");
                    }
                }
                writer.println();
            }

            writer.println(configurationPanel.traseu1);
            writer.println(configurationPanel.traseu2);
            writer.println(configurationPanel.conexiune);
            writer.println(configurationPanel.contorPlayer);

            WritableImage writableImage = new WritableImage((int) canvasPanel.getWidth(), (int) canvasPanel.getHeight());
            SnapshotParameters snapshotParameters = new SnapshotParameters();
            canvasPanel.snapshot(snapshotParameters, writableImage);

            //Export the current image of the game board into a PNG file.
            File outputFile;
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            String timestamp = now.format(formatter);
            outputFile = new File(desktopPath + "screenshot_" + timestamp + ".png");

            try {
                ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", outputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }




    }

    /**
     * functie ce citeste dintr-un fisier anumite date si reia jocul de unde a ramas cand a fost salvat
     * @throws FileNotFoundException
     */
    public void uploadeaza() throws FileNotFoundException{
        String desktopPath = System.getProperty("user.home") + "/Desktop/";
        String filePath = desktopPath + "Copie1.txt";

        CanvasPanel canvasNou = new CanvasPanel();
        MainFrame mainFrame = new MainFrame();
        ConfigurationPanel configPanel = new ConfigurationPanel(canvasNou);
        ControlPanel controlPanel = new ControlPanel(canvasNou, configPanel);
        mainFrame.setBottom(controlPanel);
        mainFrame.setTop(configPanel);
        mainFrame.setCenter(canvasNou);
        Scene scene = new Scene(mainFrame, 1000, 1000);
        Stage stage = (Stage) this.getScene().getWindow();
        stage.setScene(scene);

        ArrayList<ArrayList<Integer>> listaDeAdiacenta1 = new ArrayList<>();

        ArrayList<ArrayList<Integer>> listaDeAdiacenta2 = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int numarBuline = Integer.parseInt(reader.readLine());
            configPanel.setNumarBuline(numarBuline);
            double[][] matrix = new double[10][];
            for (int i = 0; i < 10; i++) {
                String[] rowValues = reader.readLine().split(",");
                double[] row = new double[rowValues.length + 1];
                for (int j = 1; j < row.length; j++) {
                    row[j] = Double.parseDouble(rowValues[j - 1]);
                }
                matrix[i] = row;
            }
            configPanel.setMatrix(matrix);

            GraphicsContext gc = canvasNou.getCanvas().getGraphicsContext2D();
            gc.setFill(Color.BLACK);

            double centerX = canvasNou.getWidth() / 2;
            double centerY = canvasNou.getHeight() / 2;
            double radius = Math.min(centerX, centerY) * 0.8;

            for (int i = 0; i < numarBuline; i++) {
                double angle = i * 2 * Math.PI / numarBuline;
                double x = centerX + radius * Math.cos(angle);
                double y = centerY + radius * Math.sin(angle);

                gc.fillOval(x, y, 5, 5);
            }
            String traseu1 = new String();
            traseu1 = reader.readLine();

            String traseu2 = new String();
            traseu2 = reader.readLine();


            String conexiune = new String();
            conexiune = reader.readLine();




            int contorPlayer;
            String contor=new String();
            contor=reader.readLine();
            contorPlayer=Integer.parseInt(contor);

            int primaCifra;
            int aDouaCifra;
            int primaCifra1;
            int aDouaCifra1;

            gc.setStroke(Color.YELLOW);
            gc.setLineWidth(13);

            configPanel.traseu1= traseu1;
            configPanel.traseu2=traseu2;

            configPanel.setCuloarePlayer1(Color.YELLOW);
            configPanel.setCuloarePlayer2(Color.RED);

            for (int i = 0; i < numarBuline; i++) {
                listaDeAdiacenta1.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < numarBuline; i++) {
                listaDeAdiacenta2.add(new ArrayList<Integer>());
            }


            for (int i = 0; i < traseu1.length() - 1; i += 2) {
                if (i + 1 < traseu1.length()) {
                    primaCifra = Character.getNumericValue(traseu1.charAt(i));
                    aDouaCifra = Character.getNumericValue(traseu1.charAt(i + 1));
                    gc.strokeLine(matrix[primaCifra][2], matrix[primaCifra][3], matrix[aDouaCifra][2], matrix[aDouaCifra][3]);
                    listaDeAdiacenta1.get(primaCifra).add(aDouaCifra);
                    listaDeAdiacenta1.get(aDouaCifra).add(primaCifra);
                    configPanel.lines.add(new Line(matrix[primaCifra][2], matrix[primaCifra][3], matrix[aDouaCifra][2], matrix[aDouaCifra][3],Color.YELLOW));

                    for(int k=0; k<conexiune.length()-1; k+=2)
                    {
                        if (k + 1 < conexiune.length()) {
                            primaCifra1 = Character.getNumericValue(conexiune.charAt(k));
                            aDouaCifra1 = Character.getNumericValue(conexiune.charAt(k + 1));
                            if((primaCifra1 == primaCifra && aDouaCifra1 == aDouaCifra ) || (primaCifra1 == aDouaCifra && aDouaCifra1 ==  primaCifra ))
                            {
                                conexiune = conexiune.replace(primaCifra1 + "" + aDouaCifra1, "");
                            }
                        }

                    }
                }
            }
            gc.setStroke(Color.RED);
            for ( int i = 0; i < traseu2.length() - 1 ; i += 2) {
                if(i+1 <  traseu2.length()) {
                    primaCifra = Character.getNumericValue(traseu2.charAt(i));
                    aDouaCifra = Character.getNumericValue(traseu2.charAt(i + 1));
                    gc.strokeLine(matrix[primaCifra][2], matrix[primaCifra][3], matrix[aDouaCifra][2], matrix[aDouaCifra][3]);
                    listaDeAdiacenta2.get(primaCifra).add(aDouaCifra);
                    listaDeAdiacenta2.get(aDouaCifra).add(primaCifra);
                    configPanel.lines.add(new Line(matrix[primaCifra][2], matrix[primaCifra][3], matrix[aDouaCifra][2], matrix[aDouaCifra][3],Color.RED));

                    for(int k=0; k<conexiune.length()-1; k+=2)
                    {
                        if (k + 1 < conexiune.length()) {
                            primaCifra1 = Character.getNumericValue(conexiune.charAt(k));
                            aDouaCifra1 = Character.getNumericValue(conexiune.charAt(k + 1));
                            if((primaCifra1 == primaCifra && aDouaCifra1 == aDouaCifra ) || (primaCifra1 == aDouaCifra && aDouaCifra1 ==  primaCifra ))
                            {
                                conexiune = conexiune.replace(primaCifra1 + "" + aDouaCifra1, "");
                            }
                        }

                    }
                }
            }
            gc.setStroke(Color.BLACK);
            for (int i = 0; i < conexiune.length() - 1; i += 2) {
                if (i + 1 < conexiune.length()) {
                    primaCifra = Character.getNumericValue(conexiune.charAt(i));
                    aDouaCifra = Character.getNumericValue(conexiune.charAt(i + 1));
                    gc.strokeLine(matrix[primaCifra][2], matrix[primaCifra][3], matrix[aDouaCifra][2], matrix[aDouaCifra][3]);
                    configPanel.lines.add(new Line(matrix[primaCifra][2], matrix[primaCifra][3], matrix[aDouaCifra][2], matrix[aDouaCifra][3],Color.BLACK));

                }
            }

            for (int i = 0; i < conexiune.length() - 1; i += 2) {
                if (i + 1 < conexiune.length()) {
                    primaCifra = Character.getNumericValue(conexiune.charAt(i));
                    aDouaCifra = Character.getNumericValue(conexiune.charAt(i + 1));
                    gc.strokeLine(matrix[primaCifra][2], matrix[primaCifra][3], matrix[aDouaCifra][2], matrix[aDouaCifra][3]);

                }
            }
            configPanel.setListaDeAdiacenta1(listaDeAdiacenta1);
            configPanel.setListaDeAdiacenta2(listaDeAdiacenta2);
            configPanel.contorPlayer=contorPlayer;

        } catch (IOException e) {
            e.printStackTrace();
        }
        configPanel.startJoc(canvasNou);
    }
}


