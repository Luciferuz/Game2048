package Package;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    private GameField gameField;
    private Graphics userInterface;
    private int[][] field;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        gameField = new GameField(4,4, 2048);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Package/gameinterface.fxml"));
        Parent content = loader.load();
        Controller controller = loader.getController();

        controller.setGameField(gameField);
        controller.setGraphics(userInterface);

        BorderPane root = new BorderPane();
        root.setCenter(content);
        //тут двойной цикл для картинок addChildren в pane


        Scene scene = new Scene(root, 570, 393);
        scene.getRoot().requestFocus();
        stage.setTitle("2048");
        stage.setScene(scene);
        stage.show();
    }

    public void launcherScreen()  {
        //try {
        //    Parent content = FXMLLoader.load(getClass().getResource("/Package/startscreen.fxml"));
        //    root.setCenter(content);
        //    Scene scene = new Scene(root, 570, 393);
        //    stage.setScene(scene);
        //    stage.show();
       // } catch (IOException e) {
         //   e.printStackTrace();
        //}
        ////////////////
        ////////////////

    }


    public void startGame() throws IOException { //при нажатии на кнопку старт в стартскрин вызывается метод и открывается игровое поле

        //Parent content = FXMLLoader.load(getClass().getResource("/Package/gameinterface.fxml"));
        //root.setCenter(content);
    }
}
