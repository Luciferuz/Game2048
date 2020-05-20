package Package;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;


public class Controller {

    public FlowPane flowPane;
    public ComboBox comboBoxXCells;
    public ComboBox comboBoxYCells;
    public ComboBox comboBoxWinCase;

    private GameField gameField;
    private Graphics userInterface;
    private int countX;
    private int countY;
    private int winCase;

    public void setImagesFlowPane() {
        flowPane.getChildren().clear();
        ImageView[][] images = userInterface.getImages();
        for (int y = 0; y < gameField.getCountCellsX(); y++) {
            for (int x = 0; x < gameField.getCountCellsY(); x++) {
                flowPane.getChildren().add(images[x][y]);
            }
        }
    }

    @FXML
    public void keyboardPress(KeyEvent keyEvent) { //не работает, исправить
        System.out.println("кнопка на клавиатуре");
        System.out.println("Key Pressed"); // print a message
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
            }
        }
    }

    public void exit() {
        System.out.println("Нажата кнопка выхода, надо включить первый стартовый экран");
        System.exit(0);
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
        setImagesFlowPane();
    }

    public void setStartScreen() {
        ObservableList<Integer> listXY = FXCollections.observableArrayList(3,4,5,6,7,8,9,10);
        ObservableList<Integer> listWinCase = FXCollections.observableArrayList(32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536);
        comboBoxXCells.setItems(listXY);
        comboBoxYCells.setItems(listXY);
        comboBoxWinCase.setItems(listWinCase);
    }

    public void startGame() {
        winCase = (int) comboBoxWinCase.getValue();
        countX = (int) comboBoxXCells.getValue();
        countY = (int) comboBoxYCells.getValue();
    }

    public int getCountX() {
        return countX;
    }

    public int getCountY() {
        return countY;
    }

    public int getWinCase() {
        return winCase;
    }
}
