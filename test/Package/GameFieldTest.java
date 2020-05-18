package Package;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameFieldTest { //mockito использовать

    @Test
    void left() {

    }

    @Test
    void right() {
    }

    @Test
    void down() {
    }

    @Test
    void up() {
    }

    @Test
    void getField() {
        GameField gameField = new GameField(4,4, 2048);
        int[][] expected = gameField.getField();
        int[][] actual = {
                {1,2,0,4},
                {1,2,0,4},
                {1,2,0,4},
                {1,2,0,4}
        };

        assertEquals(expected, actual);
    }
}