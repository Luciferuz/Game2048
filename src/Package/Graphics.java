package Package;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Graphics {

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

    public Graphics(int[][] field) {
        this.field = field;
    }

    public void updateUI() {

        for (int x = 0; x< 4; x++) {
            for (int y=0; y<4; y++) {
                System.out.print(field[x][y]);
            }
            System.out.println();
        }

        try {
            cell00.setImage(new Image(new FileInputStream("src/images/" + field[0][0] + ".png"))); //лучше в hashmap
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
