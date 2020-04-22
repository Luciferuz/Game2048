package Package;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        gameField.createNewCell();
        gameField.createNewCell();
        gameField.createNewCell();
        gameField.createNewCell();
        gameField.createNewCell();
        gameField.createNewCell();

        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                System.out.print(gameField.getCell(x, y));
            }
            System.out.println();
        }

        System.out.println("AFTER LEFT");

        gameField.down();

        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                System.out.print(gameField.getCell(x, y));
            }
            System.out.println();
        }
        new KeyboardInput();



    }

    Group root = new Group();


    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(root, 300, 300);

        Button startButton = new Button("Начать игру");

        startButton.setOnAction(event -> {
            startButton.setText("Произошло нажатие");
            buttonLeftPressed();
        });

        root.getChildren().add(startButton);

        JButton button = new JButton();
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("/images/left.png"));
        button.add(label);



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
