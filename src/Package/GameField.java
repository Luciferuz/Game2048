package Package;
public class GameField {

    private int[][] field;
    private static final int countCellsX = 4;
    private static final int countCellsY = 4;

    public GameField() { //заполнил массив игрового поля ячейками 0
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

}
