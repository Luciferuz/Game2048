package Package;

import javafx.scene.input.KeyEvent;

import java.awt.event.KeyListener;

public class Controller {

    //public GameField gameField;

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
        //right();
    }

    public void up() {
        //up();
    }

    public void left() {
        //left();
    }

    public void down() {
        //down();
    }
}
