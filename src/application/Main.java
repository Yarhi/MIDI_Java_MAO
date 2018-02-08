package application;

import Controllers.MainController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import static javafx.application.Platform.exit;

public class Main extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        setPrimaryStage(primaryStage);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/main_layout.fxml"));
        Parent root = fxmlLoader.load();

        Rectangle2D bounds = Screen.getPrimary().getBounds();


        MainController mainController = fxmlLoader.getController();

        Scene scene = new Scene(root);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(root.minWidth(-1));
        primaryStage.setMinHeight(root.minHeight(-1) + 50);
        primaryStage.setX((bounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((bounds.getHeight() - primaryStage.getHeight()) / 4);
        primaryStage.show();


        primaryStage.setOnCloseRequest(windowEvent -> {
            mainController.exit();
            System.exit(0);
        });
    }

    public static Stage getPrimaryStage(){
        return Main.primaryStage;
    }

    private void setPrimaryStage(Stage p){
        this.primaryStage = p;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
