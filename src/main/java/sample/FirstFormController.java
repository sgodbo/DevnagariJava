package sample;

import com.shan.scanner.Scanner;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class FirstFormController extends OutputStream implements Initializable {
    
    @FXML
    TextArea inputIDE;

    @FXML
    TextArea outputConsole;

    public void executeCode() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, URISyntaxException, MalformedURLException {

        var scanner = new Scanner();
        scanner.scan(inputIDE.getText());
        JavaClassExecutorUtil.executeJavaClassFromString(scanner.getMainClassName(), scanner.getTranslatedCodeAsString());
    }

    @Override
    public void write(int b) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) {
                appendText(String.valueOf((char) b));
            }
        };
        System.setOut(new PrintStream(out, true));
    }

    private void appendText(String str) {
        Platform.runLater(() -> outputConsole.appendText(str));
    }
}


