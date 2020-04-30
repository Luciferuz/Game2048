package Package;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameField {

    public ImageView cell00;
    public ImageView cell10;
    public ImageView cell20;
    public ImageView cell30;
    public ImageView cell01;
    public ImageView cell11;
    public ImageView cell21;
    public ImageView cell31;
    public ImageView cell02;
    public ImageView cell12;
    public ImageView cell22;
    public ImageView cell32;
    public ImageView cell03;
    public ImageView cell13;
    public ImageView cell23;
    public ImageView cell33;

    private int[][] field;
    private static final int countCellsX = 4;
    private static final int countCellsY = 4;

    public GameField() {
        //countCellsX = countX;
        //countCellsY = countY;
        clear();
        createNewCell();
        createNewCell();
        //updateUI();
    }

    private void createNewCell() {
        while (true) {
            int x = (int) ( Math.random() * countCellsX );
            int y = (int) ( Math.random() * countCellsY );
            if (field[x][y] == 0) {
                field[x][y] = 2;
                break;
            }
        }
        //updateUI();
    }

    //////////////////////////////////
    //          куда-нибудь добавить проверку
    //
    //  if (isWinEndOfGame())   System.out.println("Набралось число 2048, победа");
    //  if (noMoreEmptyCells()) System.out.println("Не осталось свободных ячеек, проигрыш");
    ///////////////////////////////////

    private boolean isWinEndOfGame() {
        //проверяю все ячейки на наличие ыигрышной(2048)
        for (int x = 0; x < countCellsX; x++) {
            for (int y = 0; y < countCellsY; y++) {
                if (field[x][y] == 2048) return true;
            }
        }
       return false;
    }

    private boolean noMoreEmptyCells() {
        //проверяю все ячейки на наличие пустой/свободной
        for (int x = 0; x < countCellsX; x++) {
            for (int y = 0; y < countCellsY; y++) {
                if (field[x][y] == 0) return false;
            }
        }
      return true;
    }

    private void clear() {
        field = new int[countCellsX][countCellsY];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = 0;
            }
        }
    }

    private void move(String direction) {
        updateUI();
        int[][] beforeMove = setArray(field);
        switch (direction) {
            case "up" : {
                for (int x = 0; x < countCellsX; x++) {
                    int[] newArray = new int[countCellsY];
                    int index = 0;
                    for (int y = 0; y < countCellsY; y++) {
                        if (field[x][y] != 0) {
                            newArray[index] = field[x][y];
                            index++;
                        }
                    }
                    for (int i = index; i < countCellsY; i++) newArray[i] = 0;
                    setColumn(x, ifNeedSum(newArray, direction));
                }
                break;
            }
            case "left" : {
                for (int y = 0; y < countCellsY; y++) {
                    int[] newArray = new int[countCellsX];
                    int index = 0;
                    for (int x = 0; x < countCellsX; x++) {
                        if (field[x][y] != 0) {
                            newArray[index] = field[x][y];
                            index++;
                        }
                    }
                    for (int i = index; i < countCellsX; i++) newArray[i] = 0;
                    setLine(y, ifNeedSum(newArray, direction));
                }
                break;
            }
            case "right" : {
                for (int y = 0; y < countCellsY; y++) {
                    int[] newArray = new int[countCellsX];
                    int index = 3;
                    for (int x = 3; x >= 0; x--) {
                        if (field[x][y] != 0) {
                            newArray[index] = field[x][y];
                            index--;
                        }
                    }
                    for (int i = index; i >= 0; i--) newArray[i] = 0;
                    setLine(y, ifNeedSum(newArray, direction));
                }
                break;
            }
            case "down" : {
                for (int x = 0; x < countCellsX; x++) {
                    int[] newArray = new int[countCellsY];
                    int index = 3;
                    for (int y = 3; y >= 0; y--) {
                        if (field[x][y] != 0) {
                            newArray[index] = field[x][y];
                            index--;
                        }
                    }
                    for (int i = index; i >= 0; i--) newArray[i] = 0;
                    setColumn(x, ifNeedSum(newArray, direction));
                }
            }
        }
        if (isMoved(beforeMove, field)) createNewCell();
        updateUI();
    }

    private int[] ifNeedSum(int[] array, String direction) { //тут использовать константы чтобы лучше читалось
        switch (direction) {
            case "up" :
            case "left" : {
                if (array[0] == array[1] && array[2] == array[3]) {
                    array[0] = array[0] * 2;
                    array[1] = array[2] * 2;
                    array[2] = 0;
                    array[3] = 0;
                }
                if (array[0] == array[1] && array[2] != array[3]) {
                    array[0] = array[0] * 2;
                    array[1] = array[2];
                    array[2] = array[3];
                    array[3] = 0;
                }
                if (array[0] != array[1] && array[1] == array[2]) {
                    array[1] = array[1] * 2;
                    array[2] = array[3];
                    array[3] = 0;
                }
                if (array[0] != array[1] && array[1] != array[2] && array[2] == array[3]) {
                    array[2] = array[2] * 2;
                    array[3] = 0;
                }
                break;
            }

            case "down" :
            case "right" : {
                if (array[3] == array[2] && array[1] == array[0]) {
                    array[3] = array[3] * 2;
                    array[2] = array[1] * 2;
                    array[1] = 0;
                    array[0] = 0;
                }
                if (array[3] == array[2] && array[1] != array[0]) {
                    array[3] = array[3] * 2;
                    array[2] = array[1];
                    array[1] = array[0];
                    array[0] = 0;
                }
                if (array[3] != array[2] && array[2] == array[1]) {
                    array[2] = array[2] * 2;
                    array[1] = array[0];
                    array[0] = 0;
                }
                if (array[3] != array[2] && array[2] != array[1] && array[1] == array[0]) {
                    array[1] = array[1] * 2;
                    array[0] = 0;
                }
            }
        }
        return array;
    }

    public void left() {
        move("left");
    }

    public void right() {
        move("right");
    }

    public void down() {
        move("down");
    }

    public void up() {
        move("up");
    }

    private void setLine(int y, int[] line) {
        for (int x = 0; x < countCellsX; x++){
            field[x][y] = line[x];
        }
    }

    private void setColumn (int x, int[] column) {
        for (int y = 0; y < countCellsY; y++) {
            field[x][y] = column[y];
        }
    }

    private int[][] setArray(int[][] array) {
        int[][] newArray = new int[countCellsX][countCellsY];
        for (int x = 0; x < countCellsX; x++) {
            System.arraycopy(array[x], 0, newArray[x], 0, countCellsY);
        }
        return newArray;
    }

    private boolean isMoved(int[][] before, int[][] after) { //было ли передвижение, чтобы создавать новую ячейку
        for (int x = 0; x < countCellsX; x++) {
            for (int y = 0; y < countCellsY; y++) {
              if (before[x][y] != after[x][y]) return true;
            }
        }
        return false;
    }

    private void updateUI() {
        /*for (int y = 0; y < countCellsY; y++) {
            for (int x = 0; x < countCellsX; x++) {

                switch (field[x][y]) {
                    case 0: {
                        String cellxy = "cell" + "x" + "y";
                        new ImageView(cellxy).setImage(new Image(new FileInputStream("src/images/up.png")));
                    }
                }

            }
        } */
        try {
            cell00.setImage(new Image(new FileInputStream("src/images/" + field[0][0] + ".png")));
            cell01.setImage(new Image(new FileInputStream("src/images/" + field[0][1] + ".png")));
            cell02.setImage(new Image(new FileInputStream("src/images/" + field[0][2] + ".png")));
            cell03.setImage(new Image(new FileInputStream("src/images/" + field[0][3] + ".png")));
            cell10.setImage(new Image(new FileInputStream("src/images/" + field[1][0] + ".png")));
            cell11.setImage(new Image(new FileInputStream("src/images/" + field[1][1] + ".png")));
            cell12.setImage(new Image(new FileInputStream("src/images/" + field[1][2] + ".png")));
            cell13.setImage(new Image(new FileInputStream("src/images/" + field[1][3] + ".png")));
            cell20.setImage(new Image(new FileInputStream("src/images/" + field[2][0] + ".png")));
            cell21.setImage(new Image(new FileInputStream("src/images/" + field[2][1] + ".png")));
            cell22.setImage(new Image(new FileInputStream("src/images/" + field[2][2] + ".png")));
            cell23.setImage(new Image(new FileInputStream("src/images/" + field[2][3] + ".png")));
            cell30.setImage(new Image(new FileInputStream("src/images/" + field[3][0] + ".png")));
            cell31.setImage(new Image(new FileInputStream("src/images/" + field[3][1] + ".png")));
            cell32.setImage(new Image(new FileInputStream("src/images/" + field[3][2] + ".png")));
            cell33.setImage(new Image(new FileInputStream("src/images/" + field[3][3] + ".png")));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void keyboardPress(KeyEvent keyEvent) {
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

    @FXML
    public void exit() {
        System.out.println("Нажата кнопка выхода, надо включить первый стартовый экран и очитстить поле до этого");
        System.exit(0);
    }
}