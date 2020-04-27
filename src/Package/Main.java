package Package;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
        GameField gameField = new GameField();
    }


    public void start(Stage stage) throws Exception {
        Parent content = FXMLLoader.load(getClass().getResource("/Package/content.fxml"));
        BorderPane root = new BorderPane();
        root.setCenter(content);
        Scene scene = new Scene(root, 650, 450);
        stage.setTitle("2048");
        stage.setScene(scene);
        stage.show();
    }

}
