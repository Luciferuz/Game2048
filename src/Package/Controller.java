package Package;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;

public class Controller {

    public FlowPane flowPane;
    private GameField gameField;
    private Graphics userInterface;
    private int[][] field = gameField.getField();

    public void setImagesFlowPane(int countX, int countY) throws FileNotFoundException {
        for (int x = 0; x < countX; x++) {
            for (int y = 0; y < countY; y++) {
                ImageView newImage = new ImageView();
                newImage.setImage(new Image(new FileInputStream("src/images/" + field[x][y] + ".png")));
                flowPane.getChildren().add(newImage);
            }
        }
    }


    public void keyboardPress(KeyEvent keyEvent) { //не работает, исправить
        System.out.println("кнопка на клавиатуре");
        System.out.println(keyEvent.getCode().isArrowKey());
        System.out.println(keyEvent.getCode().getChar());
        switch (keyEvent.getCode()) {
            case W: {
                up();
                break;
            }
            case A: {
                left();
                break;
            }
            case S: {
                down();
                break;
            }
            case D: {
                right();
                break;
            }
        }
    }

    public void exit() {
        System.out.println("Нажата кнопка выхода, надо включить первый стартовый экран и очитстить поле до этого");
        System.exit(0);
    }

    public void startGame() {

    }

    public void right() {
        gameField.right();
        userInterface.updateUI();
    }

    public void up() {
        gameField.up();
        userInterface.updateUI();
    }

    public void left() {
        gameField.left();
        userInterface.updateUI();
    }

    public void down() {
        gameField.down();
        userInterface.updateUI();
    }

    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }

    public void setGraphics(Graphics userInterface) {
        this.userInterface = userInterface;
    }
}
