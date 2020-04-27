package Package;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
        GameField gameField = new GameField();
    }


    public void start(Stage stage) throws Exception {
        Parent content = FXMLLoader.load(getClass().getResource("/Package/gameinterface.fxml"));
        BorderPane root = new BorderPane();
        root.setCenter(content);
        Scene scene = new Scene(root, 570, 393);
        stage.setTitle("2048");
        stage.setScene(scene);
        stage.show();
    }

    public void launcherScreen() throws Exception {
        new GameField();
        Parent content = FXMLLoader.load(getClass().getResource("/Package/startscreen.fxml"));
        ////////////////
        ////////////////

    }

    public void gameScreen() throws Exception {
        Parent content = FXMLLoader.load(getClass().getResource("/Package/gameinterface.fxml"));
        ////////////////
        ////////////////
    }

}
