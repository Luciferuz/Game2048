package Package;

public class GameField {

    private int[][] field;
    private int countCellsX;
    private int countCellsY;
    private int winCase;

    public GameField(int countX, int countY, int winSum) {
        countCellsX = countX;
        countCellsY = countY;
        winCase = winSum;
        clear();
        createNewCell();
        createNewCell();
    }

    private void createNewCell() {
        while (true) {
            int x = (int) (Math.random() * countCellsX);
            int y = (int) (Math.random() * countCellsY);
            if (field[x][y] == 0) {
                field[x][y] = 2;
                break;
            }
        }
    }

    private void clear() {
        field = new int[countCellsX][countCellsY];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = 0;
            }
        }
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

    private void move(String direction) {
        int[][] beforeMove = setArray(field);
        switch (direction) {
            case "up": {
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
            case "left": {
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
            case "right": {
                for (int y = 0; y < countCellsY; y++) {
                    int[] newArray = new int[countCellsX];
                    int index = newArray.length - 1;
                    for (int x = newArray.length - 1; x >= 0; x--) {
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
            case "down": {
                for (int x = 0; x < countCellsX; x++) {
                    int[] newArray = new int[countCellsY];
                    int index = newArray.length - 1;
                    for (int y = newArray.length - 1; y >= 0; y--) {
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
    }

    private int[] ifNeedSum(int[] array, String direction) {
        int length = array.length;

        switch (direction) { //если соседние равны, то делаем манипуляции, потом будут нули в массиве
            case "up" :
            case "left" : {
                for (int i = 0; i < length; i++) {
                    if (array[i] == array[i + 1]) {
                        array[i] = array[i] * 2;
                        array[i + 1] = 0;
                        i++;
                    }
                }
                break;
            }

            case "down" :
            case "right" : {
                for (int i = length - 1; i > 0; i--) {
                    if (array[i] == array[i - 1]) {
                        array[i] = array[i] * 2;
                        array[i - 1] = 0;
                        i--;
                    }
                }
            }
        }

        //теперь убираю нули из массива
        int[] newArray = new int[length];
        int index = 0;
        for (int value : array) {
            if (value != 0) {
                newArray[index] = value;
                index++;
            }
        }
        for (int i = index; i < length; i++) newArray[i] = 0;

        return newArray;
    }

    private int[] ifNeedSumOld(int[] array, String direction) { //тут использовать константы чтобы лучше читалось
        switch (direction) {
            case "up":
            case "left": {
                if (array[countCellsX - 4] == array[countCellsX - 3] && array[countCellsX - 2] == array[countCellsX - 1]) {
                    array[countCellsX - 4] = array[countCellsX - 4] * 2;
                    array[countCellsX - 3] = array[countCellsX - 2] * 2;
                    array[countCellsX - 2] = 0;
                    array[countCellsX - 1] = 0;
                }
                if (array[countCellsX - 4] == array[countCellsX - 3] && array[countCellsX - 2] != array[countCellsX - 1]) {
                    array[countCellsX - 4] = array[countCellsX - 4] * 2;
                    array[countCellsX - 3] = array[countCellsX - 2];
                    array[countCellsX - 2] = array[countCellsX - 1];
                    array[countCellsX - 1] = 0;
                }
                if (array[countCellsX - 4] != array[countCellsX - 3] && array[countCellsX - 3] == array[countCellsX - 2]) {
                    array[countCellsX - 3] = array[countCellsX - 3] * 2;
                    array[countCellsX - 2] = array[countCellsX - 1];
                    array[countCellsX - 1] = 0;
                }
                if (array[countCellsX - 4] != array[countCellsX - 3] && array[countCellsX - 3] != array[countCellsX - 2] && array[countCellsX - 2] == array[countCellsX - 1]) {
                    array[countCellsX - 2] = array[countCellsX - 2] * 2;
                    array[countCellsX - 1] = 0;
                }
                break;
            }

            case "down":
            case "right": {
                if (array[countCellsY - 1] == array[countCellsY - 2] && array[countCellsY - 3] == array[countCellsY - 4]) {
                    array[countCellsY - 1] = array[countCellsY - 1] * 2;
                    array[countCellsY - 2] = array[countCellsY - 3] * 2;
                    array[countCellsY - 3] = 0;
                    array[countCellsY - 4] = 0;
                }
                if (array[countCellsY - 1] == array[countCellsY - 2] && array[countCellsY - 3] != array[countCellsY - 4]) {
                    array[countCellsY - 1] = array[countCellsY - 1] * 2;
                    array[countCellsY - 2] = array[countCellsY - 3];
                    array[countCellsY - 3] = array[countCellsY - 4];
                    array[countCellsY - 4] = 0;
                }
                if (array[countCellsY - 1] != array[countCellsY - 2] && array[countCellsY - 2] == array[countCellsY - 3]) {
                    array[countCellsY - 2] = array[countCellsY - 2] * 2;
                    array[countCellsY - 3] = array[countCellsY - 4];
                    array[countCellsY - 4] = 0;
                }
                if (array[countCellsY - 1] != array[countCellsY - 2] && array[countCellsY - 2] != array[countCellsY - 3] && array[countCellsY - 3] == array[countCellsY - 4]) {
                    array[countCellsY - 3] = array[countCellsY - 3] * 2;
                    array[countCellsY - 4] = 0;
                }
            }
        }
        return array;
    }

    private void setLine(int y, int[] line) {
        for (int x = 0; x < countCellsX; x++) {
            field[x][y] = line[x];
        }
    }

    private void setColumn(int x, int[] column) {
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

    //////////////////////////////////////////////////////////////////////////////////////////////
    //          куда-нибудь добавить проверку                                                   //
    //                                                                                          //
    //  if (isWinEndOfGame())   System.out.println("Набралось число 2048, победа");             //
    //  if (noMoreEmptyCells()) System.out.println("Не осталось свободных ячеек, проигрыш");    //
    //////////////////////////////////////////////////////////////////////////////////////////////

    private boolean isWinEndOfGame() {
        //проверяю все ячейки на наличие ыигрышной
        for (int x = 0; x < countCellsX; x++) {
            for (int y = 0; y < countCellsY; y++) {
                if (field[x][y] == winCase) return true;
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

    public int[][] getField() {
        return field;
    }
}