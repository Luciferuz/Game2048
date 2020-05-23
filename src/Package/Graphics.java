package Package;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Graphics {

    private GameField gamefield;
    private ImageView[][] images;
    private Map<Integer, Image> picturesMap;
    private final double WIDTH = 320.0;
    private final double HEIGHT = 320.0;

    public Graphics(GameField gamefield) throws FileNotFoundException {
        this.gamefield = gamefield;

        int countX = gamefield.getCountCellsX();
        int countY = gamefield.getCountCellsY();
        images = new ImageView[countX][countY];

        setPicturesMap();
        for (int y = 0; y < countY; y++) {
            for (int x = 0; x < countX; x++) {
                ImageView newImage = new ImageView();
                newImage.setImage(picturesMap.get(gamefield.getCell(x, y)));
                newImage.setFitWidth(WIDTH/countX);
                newImage.setFitHeight(HEIGHT/countY);
                images[x][y] = newImage;
            }
        }
    }

    private void setPicturesMap() throws FileNotFoundException {
        picturesMap = new HashMap<>();
        picturesMap.put(0, new Image(new FileInputStream("src/images/0.png")));
        picturesMap.put(2, new Image(new FileInputStream("src/images/2.png")));
        picturesMap.put(4, new Image(new FileInputStream("src/images/4.png")));
        picturesMap.put(8, new Image(new FileInputStream("src/images/8.png")));
        picturesMap.put(16, new Image(new FileInputStream("src/images/16.png")));
        picturesMap.put(32, new Image(new FileInputStream("src/images/32.png")));
        picturesMap.put(64, new Image(new FileInputStream("src/images/64.png")));
        picturesMap.put(128, new Image(new FileInputStream("src/images/128.png")));
        picturesMap.put(256, new Image(new FileInputStream("src/images/256.png")));
        picturesMap.put(512, new Image(new FileInputStream("src/images/512.png")));
        picturesMap.put(1024, new Image(new FileInputStream("src/images/1024.png")));
        picturesMap.put(2048, new Image(new FileInputStream("src/images/2048.png")));
    }

    public ImageView[][] getImages(){
        return images;
    }

    public void updateUI() {
        for (int y = 0; y < gamefield.getCountCellsY(); y++) {
            for (int x = 0; x < gamefield.getCountCellsX(); x++) {
                int value = gamefield.getCell(x, y);
                images[x][y].setImage(picturesMap.get(value));
            }
        }
        checkLoseAlert();
    }

    private void checkLoseAlert() {
        if (!gamefield.isThereMoves()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("2048");
            alert.setHeaderText("Игра закончена!");
            alert.show();
        }
    }

    public void setWinAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("2048");
        alert.setHeaderText("Вы выиграли! Выигрышная ячейка увеличена до " + gamefield.getWinCase());
        alert.show();
    }

}
