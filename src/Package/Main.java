package Package;

import javafx.application.Application;
import javafx.scene.Group;
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
        //launch(args);

        GameField gameField = new GameField();

        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                System.out.print(gameField.getCell(x, y));
            }
            System.out.println();
        }

        System.out.println("sssssss");

        gameField.left();

        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                System.out.print(gameField.getCell(x, y));
            }
            System.out.println();
        }
    }


    @Override
    public void start(Stage stage) throws Exception {

    }

}
