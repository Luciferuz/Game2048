package Package;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.ReturnsElementsOf;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GameFieldTest {

    @Test
    void all() {
        List<Integer> listX = List.of(3, 3, 1, 2, 5, 2, 2, 0, 1, 2, 3, 3, 6, 6, 0, 1, 3, 4, 1);
        List<Integer> listY = List.of(3, 4, 6, 0, 0, 1, 1, 1, 5, 3, 2, 1, 3, 4, 1, 6, 2, 4, 6);
        GameField gameFieldMock = Mockito.spy(new GameField(7, 7, 16384));
        Mockito.when(gameFieldMock.getRandomX()).then(new ReturnsElementsOf(listX));
        Mockito.when(gameFieldMock.getRandomY()).then(new ReturnsElementsOf(listY));
        gameFieldMock.newGame();

        gameFieldMock.up();
        gameFieldMock.left();
        gameFieldMock.left();
        gameFieldMock.up();
        gameFieldMock.right();
        gameFieldMock.up();
        gameFieldMock.down();
        gameFieldMock.down();
        gameFieldMock.up();
        gameFieldMock.right();
        gameFieldMock.left();
        gameFieldMock.up();
        gameFieldMock.right();
        gameFieldMock.down();
        gameFieldMock.left();
        gameFieldMock.right();
        gameFieldMock.down();

        int[][] actual = gameFieldMock.getField();
        int[][] expected = {
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,2},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,2,8},
                {0,0,0,0,0,0,16},
                {0,0,0,0,4,4,2},
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void left() {
        List<Integer> listX = List.of(0, 2, 4, 2, 1);
        List<Integer> listY = List.of(1, 4, 3, 3, 2);
        GameField gameFieldMock = Mockito.spy(new GameField(5, 5, 4096));
        Mockito.when(gameFieldMock.getRandomX()).then(new ReturnsElementsOf(listX));
        Mockito.when(gameFieldMock.getRandomY()).then(new ReturnsElementsOf(listY));
        gameFieldMock.newGame();
        gameFieldMock.left();
        gameFieldMock.left();
        gameFieldMock.left();

        int[][] actual = gameFieldMock.getField();
        int[][] expected = {
                {0,2,0,4,2},
                {0,0,2,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void right() {
        List<Integer> listX = List.of(0, 2, 1, 2, 1);
        List<Integer> listY = List.of(1, 3, 3, 1, 2);
        GameField gameFieldMock = Mockito.spy(new GameField(4, 4, 1024));
        Mockito.when(gameFieldMock.getRandomX()).then(new ReturnsElementsOf(listX));
        Mockito.when(gameFieldMock.getRandomY()).then(new ReturnsElementsOf(listY));
        gameFieldMock.newGame();
        gameFieldMock.right();
        gameFieldMock.right();
        gameFieldMock.right();

        int[][] actual = gameFieldMock.getField();
        int[][] expected = {
                {0,0,0,0},
                {0,0,2,0},
                {0,0,0,0},
                {0,4,0,4}
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void down() {
        List<Integer> listX = List.of(4, 5, 1, 5, 1);
        List<Integer> listY = List.of(1, 3, 3, 0, 0);
        GameField gameFieldMock = Mockito.spy(new GameField(6, 6, 512));
        Mockito.when(gameFieldMock.getRandomX()).then(new ReturnsElementsOf(listX));
        Mockito.when(gameFieldMock.getRandomY()).then(new ReturnsElementsOf(listY));
        gameFieldMock.newGame();
        gameFieldMock.down();
        gameFieldMock.down();
        gameFieldMock.down();

        int[][] actual = gameFieldMock.getField();
        int[][] expected = {
                {0,0,0,0,0,0},
                {2,0,0,0,0,2},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,2},
                {0,0,0,0,0,4},
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void up() {
        List<Integer> listX = List.of(2, 2, 1, 1, 0);
        List<Integer> listY = List.of(1, 2, 2, 1, 2);
        GameField gameFieldMock = Mockito.spy(new GameField(3, 3, 32));
        Mockito.when(gameFieldMock.getRandomX()).then(new ReturnsElementsOf(listX));
        Mockito.when(gameFieldMock.getRandomY()).then(new ReturnsElementsOf(listY));
        gameFieldMock.newGame();
        gameFieldMock.up();
        gameFieldMock.up();
        gameFieldMock.up();

        int[][] actual = gameFieldMock.getField();
        int[][] expected = {
                {0,0,2},
                {4,0,0},
                {4,0,0},
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void getField() {
        List<Integer> listX = List.of(4, 1);
        List<Integer> listY = List.of(0, 3);
        GameField gameFieldMock = Mockito.spy(new GameField(5, 5, 2048));
        Mockito.when(gameFieldMock.getRandomX()).then(new ReturnsElementsOf(listX));
        Mockito.when(gameFieldMock.getRandomY()).then(new ReturnsElementsOf(listY));
        gameFieldMock.newGame();

        int[][] actual = gameFieldMock.getField();
        int[][] expected = {
                {0,0,0,0,0},
                {0,0,0,2,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {2,0,0,0,0},
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void getCell() {
        List<Integer> listX = List.of(0, 2);
        List<Integer> listY = List.of(1, 1);
        GameField gameFieldMock = Mockito.spy(new GameField(4, 4, 2048));
        Mockito.when(gameFieldMock.getRandomX()).then(new ReturnsElementsOf(listX));
        Mockito.when(gameFieldMock.getRandomY()).then(new ReturnsElementsOf(listY));
        gameFieldMock.newGame();

        assertEquals(2, gameFieldMock.getCell(0, 1));
        assertEquals(2, gameFieldMock.getCell(2, 1));
    }

    @Test
    void getCountCellsX() {
        GameField game1 = new GameField(4,4, 1024);
        GameField game2 = new GameField(3,2, 512);
        GameField game3 = new GameField(1,43, 2048);
        GameField game4 = new GameField(2,6, 4096);

        assertEquals(4, game1.getCountCellsX());
        assertEquals(3, game2.getCountCellsX());
        assertEquals(1, game3.getCountCellsX());
        assertEquals(2, game4.getCountCellsX());
        assertNotEquals(1, game1.getCountCellsX());
        assertNotEquals(6, game2.getCountCellsX());
        assertNotEquals(8, game3.getCountCellsX());
        assertNotEquals(12, game4.getCountCellsX());
    }

    @Test
    void getCountCellsY() {
        GameField game1 = new GameField(4,4, 1024);
        GameField game2 = new GameField(3,2, 512);
        GameField game3 = new GameField(1,43, 2048);
        GameField game4 = new GameField(2,6, 4096);

        assertEquals(4, game1.getCountCellsY());
        assertEquals(2, game2.getCountCellsY());
        assertEquals(43, game3.getCountCellsY());
        assertEquals(6, game4.getCountCellsY());
        assertNotEquals(62, game1.getCountCellsY());
        assertNotEquals(12, game2.getCountCellsY());
        assertNotEquals(34, game3.getCountCellsY());
        assertNotEquals(0, game4.getCountCellsY());
    }
}