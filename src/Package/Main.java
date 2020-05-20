package Package;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private GameField gameField;
    private Graphics userInterface;
    private int countCellsX = 4;
    private int countCellsY = 4;
    private int winCase = 2048;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Package/startscreen.fxml"));
        Parent content = loader.load();
        Controller controller = loader.getController();
        controller.setStartScreen();

        countCellsX = controller.getCountX();
        countCellsY = controller.getCountY();
        winCase = controller.getWinCase();

        controller.setGameField(gameField);
        controller.setGraphics(userInterface);

        BorderPane root = new BorderPane();
        root.setCenter(content);

        Scene scene = new Scene(root, 570, 393);
        scene.getRoot().requestFocus();
        stage.setTitle("2048");
        stage.setScene(scene);
        stage.show();
    }

    public void startGame() throws Exception { //при нажатии на кнопку старт в стартскрин вызывается метод и открывается игровое поле
        gameField = new GameField(countCellsX, countCellsY, winCase);
        gameField.newGame();
        userInterface = new Graphics(gameField);
        Parent content = FXMLLoader.load(getClass().getResource("/Package/gameinterface1.fxml"));
        BorderPane root = new BorderPane();
        root.setCenter(content);
        Scene scene = new Scene(root, 570, 393);
        scene.getRoot().requestFocus();

        start(stage);
    }
}
