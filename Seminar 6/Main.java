import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.security.KeyStore;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * creez pagina principala si adauga panourile catre ei
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        MainFrame mainFrame = new MainFrame();
        Scene scene = new Scene(mainFrame, 1000, 1000);
        stage.setScene(scene);
        stage.setTitle("My Drawing Application");
        stage.show();
    }
}