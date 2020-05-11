package Package;
import javafx.scene.input.KeyEvent;

import javax.swing.*;
import java.awt.event.KeyAdapter;


public class Controller {

    private GameField gameField;
    private Graphics userInterface;


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
