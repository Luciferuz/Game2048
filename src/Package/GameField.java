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
        createNewCell();
        createNewCell();
    }

    public void createNewCell() {
        while (true) {
            int x = (int) ( Math.random() * countCellsX );
            int y = (int) ( Math.random() * countCellsY );
            if (field[x][y] == 0) {
                field[x][y] = 2;
                break;
            }
        }
    }

    public int getCell(int x, int y) {
        return field[x][y];
    }

    public void setCell(int x, int y, int value) {
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

    }

    public void up() {

    }

    public void down() {

    }

    public void setLine(int y, int[] line) {
        for (int x = 0; x < countCellsX; x++){
            field[x][y] = line[x];
        }
    }

    public int[] getLine(int y) {
        int[] line = new int[countCellsX];
        for (int x = 0; x < countCellsX; x++) {
            line[x] = field[x][y];
        }
        return line;
    }

    public void setColumn (int x, int[] column) {
        for (int y = 0; y < countCellsY; y++) {
            field[x][y] = column[y];
        }
    }

    public int[] getColumn(int x) {
        int[] column = new int[countCellsY];
        for (int y = 0; y < countCellsY; y++) {
            column[y] = field[x][y];
        }
        return column;
    }

    public boolean isMoved(int[][] before, int[][] after) { //было ли передвижение, чтобы создавать новую ячейку
        return before != after;
    }

}
