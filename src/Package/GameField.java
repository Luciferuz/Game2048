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

    public GameField() { //заполнил массив игрового поля ячейками 0
        //countCellsX = countX;
        //countCellsY = countY;

        field = new int[countCellsX][countCellsY];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = 0;
            }
        }
        //создал первые 2 ячейки
        createNewCell();
        createNewCell();
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
    }

    private int getCell(int x, int y) {
        return field[x][y];
    }

    private void setCell(int x, int y, int value) {
        field[x][y] = value;
    }

    public void left() {
        //переместил все влево, игнорируя нули
        for (int y = 0; y < countCellsY; y++) {
            int[] newLine = new int[countCellsX];
            int index = 0;
            for (int x = 0; x < countCellsX; x++) {
                if (field[x][y] != 0) {
                    newLine[index] = field[x][y];
                    index++;
                }
            }
            for (int i = index; i < countCellsX; i++) newLine[i] = 0;

            //если нужно складываю
            if (newLine[0] == newLine[1] && newLine[2] == newLine[3]) {
                newLine[0] = newLine[0] * 2;
                newLine[1] = newLine[2] * 2;
                newLine[2] = 0;
                newLine[3] = 0;
            }

            if (newLine[0] == newLine[1] && newLine[2] != newLine[3]) {
                newLine[0] = newLine[0] * 2;
                newLine[1] = newLine[2];
                newLine[2] = newLine[3];
                newLine[3] = 0;
            }

            if (newLine[0] != newLine[1] && newLine[1] == newLine[2]) {
                newLine[1] = newLine[1] * 2;
                newLine[2] = newLine[3];
                newLine[3] = 0;
            }

            if (newLine[0] != newLine[1] && newLine[1] != newLine[2] && newLine[2] == newLine[3]) {
                newLine[2] = newLine[2] * 2;
                newLine[3] = 0;
            }

            //присвоил новую линию
            setLine(y, newLine);
        }
    }

    public void right() {
        //переместил все вправо, игнорируя нули
        for (int y = 0; y < countCellsY; y++) {
            int[] newLine = new int[countCellsX];
            int index = 3;
            for (int x = 3; x >= 0; x--) {
                if (field[x][y] != 0) {
                    newLine[index] = field[x][y];
                    index--;
                }
            }
            for (int i = index; i >= 0; i--) newLine[i] = 0;

            //если нужно складываю
            if (newLine[3] == newLine[2] && newLine[1] == newLine[0]) {
                newLine[3] = newLine[3] * 2;
                newLine[2] = newLine[1] * 2;
                newLine[1] = 0;
                newLine[0] = 0;
            }

            if (newLine[3] == newLine[2] && newLine[1] != newLine[0]) {
                newLine[3] = newLine[3] * 2;
                newLine[2] = newLine[1];
                newLine[1] = newLine[0];
                newLine[0] = 0;
            }

            if (newLine[3] != newLine[2] && newLine[2] == newLine[1]) {
                newLine[2] = newLine[2] * 2;
                newLine[1] = newLine[0];
                newLine[0] = 0;
            }

            if (newLine[3] != newLine[2] && newLine[2] != newLine[1] && newLine[1] == newLine[0]) {
                newLine[1] = newLine[1] * 2;
                newLine[0] = 0;
            }

            //присвоил новую линию
            setLine(y, newLine);
        }
    }

    public void down() {
        //переместил все вниз, игнорируя нули
        for (int x = 0; x < countCellsX; x++) {
            int[] newColumn = new int[countCellsY];
            int index = 3;
            for (int y = 3; y >= 0; y--) {
                if (field[x][y] != 0) {
                    newColumn[index] = field[x][y];
                    index--;
                }
            }
            for (int i = index; i >= 0; i--) newColumn[i] = 0;

            //если нужно складываю
            if (newColumn[3] == newColumn[2] && newColumn[1] == newColumn[0]) {
                newColumn[3] = newColumn[3] * 2;
                newColumn[2] = newColumn[1] * 2;
                newColumn[1] = 0;
                newColumn[0] = 0;
            }

            if (newColumn[3] == newColumn[2] && newColumn[1] != newColumn[0]) {
                newColumn[3] = newColumn[3] * 2;
                newColumn[2] = newColumn[1];
                newColumn[1] = newColumn[0];
                newColumn[0] = 0;
            }

            if (newColumn[3] != newColumn[2] && newColumn[2] == newColumn[1]) {
                newColumn[2] = newColumn[2] * 2;
                newColumn[1] = newColumn[0];
                newColumn[0] = 0;
            }

            if (newColumn[3] != newColumn[2] && newColumn[2] != newColumn[1] && newColumn[1] == newColumn[0]) {
                newColumn[1] = newColumn[1] * 2;
                newColumn[0] = 0;
            }

            //присвоил новый столбец
            setColumn(x, newColumn);
        }
    }

    public void up() {
        //переместил все вверх, игнорируя нули
        for (int x = 0; x < countCellsX; x++) {
            int[] newColumn = new int[countCellsY];
            int index = 0;
            for (int y = 0; y < countCellsY; y++) {
                if (field[x][y] != 0) {
                    newColumn[index] = field[x][y];
                    index++;
                }
            }
            for (int i = index; i < countCellsY; i++) newColumn[i] = 0;

            //если нужно складываю
            if (newColumn[0] == newColumn[1] && newColumn[2] == newColumn[3]) {
                newColumn[0] = newColumn[0] * 2;
                newColumn[1] = newColumn[2] * 2;
                newColumn[2] = 0;
                newColumn[3] = 0;
            }

            if (newColumn[0] == newColumn[1] && newColumn[2] != newColumn[3]) {
                newColumn[0] = newColumn[0] * 2;
                newColumn[1] = newColumn[2];
                newColumn[2] = newColumn[3];
                newColumn[3] = 0;
            }

            if (newColumn[0] != newColumn[1] && newColumn[1] == newColumn[2]) {
                newColumn[1] = newColumn[1] * 2;
                newColumn[2] = newColumn[3];
                newColumn[3] = 0;
            }

            if (newColumn[0] != newColumn[1] && newColumn[1] != newColumn[2] && newColumn[2] == newColumn[3]) {
                newColumn[2] = newColumn[2] * 2;
                newColumn[3] = 0;
            }

            //присвоил новый столбец
            setColumn(x, newColumn);
        }
    }

    private void setLine(int y, int[] line) {
        for (int x = 0; x < countCellsX; x++){
            field[x][y] = line[x];
        }
    }

    private int[] getLine(int y) {
        int[] line = new int[countCellsX];
        for (int x = 0; x < countCellsX; x++) {
            line[x] = field[x][y];
        }
        return line;
    }

    private void setColumn (int x, int[] column) {
        for (int y = 0; y < countCellsY; y++) {
            field[x][y] = column[y];
        }
    }

    private int[] getColumn(int x) {
        int[] column = new int[countCellsY];
        for (int y = 0; y < countCellsY; y++) {
            column[y] = field[x][y];
        }
        return column;
    }

    private boolean isMoved(int[][] before, int[][] after) { //было ли передвижение, чтобы создавать новую ячейку
        return before != after;
    }


    @FXML
    public void clickUp() {
        up();
        System.out.println("Up");
        createNewCell();
        updateUI();
    }
    @FXML
    public void clickDown() {
        down();
        System.out.println("Down");
        createNewCell();
        updateUI();
    }
    @FXML
    public void clickRight() {
        right();
        System.out.println("Right");
        createNewCell();
        updateUI();
    }
    @FXML
    public void clickLeft() {
        left();
        System.out.println("Left");
        createNewCell();
        updateUI();
    }
    @FXML
    public void keyboardPress(KeyEvent keyEvent) {
        System.out.println("кнопка на клавиатуре");
        System.out.println(keyEvent.getCode().isArrowKey());
        System.out.println(keyEvent.getCode().getChar());

        switch (keyEvent.getCode()) {
            case W: {
                clickUp();
                break;
            }
            case A: {
                clickLeft();
                break;
            }
            case S: {
                clickDown();
                break;
            }
            case D: {
                clickRight();
                break;
            }
        }
    }

    public void updateUI() {
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
}
