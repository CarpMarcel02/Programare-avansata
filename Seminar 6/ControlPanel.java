import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

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
     * adaug butoanele save, load,reset, exit si le pun pe plansa si le atribui valori pentru apasarea lor
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

        // Add the UI components to a grid pane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.add(loadButton, 37, 0);
        grid.add(saveButton, 38, 0);
        grid.add(resetButton, 39, 0);
        grid.add(exitButton, 40, 0);

        resetButton.setOnAction(event -> {
                    canvasPanel.reset(canvasPanel);
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

        // Add the grid pane to this panel
        this.getChildren().add(grid);
    }

    /**
     * functia salveaza pur si simplu parcurge matricea de puncte cu tot cu coordonatele ei si o salveaza pe desktop intr-un fisier,
     * iar ca sa pastreze conexiunea intre fiecarre nod, va face un string in care salveaza punctu de plecare si punctul in care ajunge
     */
    public void salveaza() {
        String desktopPath = System.getProperty("user.home") + "/Desktop/";
        try (PrintWriter writer = new PrintWriter(new FileWriter(desktopPath + "Copie1.txt"))) {
            for (double[] row : configurationPanel.matrix) {
                for (int i = 1; i < row.length; i++) {
                    writer.print(row[i]);
                    if (i < row.length - 1) {
                        writer.print(",");
                    }
                }
                writer.println();
            }
            // Write string to file
            writer.println(configurationPanel.conexiune);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * ia din fisierul salvat pe desktop datele si le prelucreaza, redeseneaza liniile luand din string 2 cate 2 elemente, si pentru ele doua le parcurge in matrice
     * si traseaza liniile
     * @throws FileNotFoundException
     */
    public void uploadeaza() throws FileNotFoundException {
        try {
            String desktopPath = System.getProperty("user.home") + "/Desktop/";
            File file = new File(desktopPath, "Copie1.txt");
            Scanner scanner = new Scanner(file);

            double[][] matrix = new double[10][3];
            int row = 0;
            while (scanner.hasNextLine() && row < 10) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                if (values.length != 3) {
                    throw new InputMismatchException("Bad file format");
                }
                matrix[row][0] = Double.parseDouble(values[0]);
                matrix[row][1] = Double.parseDouble(values[1]);
                matrix[row][2] = Double.parseDouble(values[2]);
                row++;
            }
            int lungimeSir;
            String str = new String();
            if (scanner.hasNextLine()) {
                str = scanner.nextLine();
                lungimeSir = str.length();
            } else
                lungimeSir = 0;


            char primaCifra;
            char aDouaCifra;
            System.out.println(lungimeSir);

            for (double i = 0; i < lungimeSir - 1; i = i + 2) {
                primaCifra = (char) Character.getNumericValue(str.charAt((int) Math.floor(i)));
                aDouaCifra = (char) Character.getNumericValue(str.charAt((int) Math.floor(i) + 1));

                configurationPanel.drawLine(matrix[primaCifra][1], matrix[primaCifra][2], matrix[aDouaCifra][1], matrix[aDouaCifra][2]);
                //configurationPanel.dezactiveazaButoanele();

            }

            scanner.close();


        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (InputMismatchException e) {
            System.out.println("Bad file format!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format!");
        }
    }
}