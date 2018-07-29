package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = getClass().getClassLoader().getResource("firstForm.fxml");
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("देवनागरी कोड एडिटर");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        primaryStage.setScene(new Scene(root, screenSize.getWidth()/2, screenSize.getHeight()/2));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
