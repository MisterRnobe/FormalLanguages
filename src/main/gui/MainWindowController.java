package main.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import main.language.Runner;

import java.io.IOException;
import java.io.OutputStream;

public class MainWindowController {
    @FXML
    private TextArea code;
    @FXML
    private Parent root;
    @FXML
    private TextArea log;


    @FXML
    private void run() {
        log.setText("");
        Runner.run(code.getText());

    }

    @FXML
    private void initialize() {
    }

    public OutputStream getOutputStream()
    {
        return new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                log.setText(log.getText() + ((char)b));
            }
        };
    }


    public Parent getRoot() {
        return root;
    }

    static MainWindowController create() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainWindowController.class.getResource("MainWindow.fxml"));
        loader.load();
        return loader.getController();
    }
}
