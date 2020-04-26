package Package;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;
import java.util.Collection;

public class Main extends Application {

    public static void main(String[] args)  {
        launch(args);
        GameField gameField = new GameField();

    }


    public void start(Stage stage) throws Exception {


        //Button startButton = new Button("Начать игру");

        //startButton.setOnAction(event -> {
        //    startButton.setText("Произошло нажатие");
       //     buttonLeftPressed();
       // });

        //root.getChildren().add(startButton);


        Group group = new Group();

        Parent content = FXMLLoader.load(getClass().getResource("/src/Package/Untitled1.fxml"));
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 300, 300);
        root.setCenter(content);
        group.getChildren().add(root);

        stage.setTitle("2048");
        stage.setScene(scene);
        stage.show();
    }

    public void buttonLeftPressed() {

    }

    public void buttonRightPressed() {

    }

    public void buttonUpPressed() {

    }

    public void buttonDownPressed() {

    }

}
