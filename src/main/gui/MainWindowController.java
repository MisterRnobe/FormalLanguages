package main.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import main.language.Runner;

import java.io.*;
import java.util.Scanner;

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
        System.out.println(code.getText());

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
    @FXML
    private void save()
    {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save...");
        chooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("My lang file","*.f")
        );
        File f = chooser.showSaveDialog(ApplicationController.getStage());
        if (f != null)
        {
            try(FileOutputStream stream = new FileOutputStream(f))
            {
                OutputStreamWriter w = new OutputStreamWriter(stream);
                w.write(code.getText());
                w.flush();
            }
            catch (IOException e)
            {
                log.setText("Could not save the file...");
            }
        }
    }
    @FXML
    private void load()
    {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open...");
        chooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("My lang file","*.f")
        );
        File f = chooser.showOpenDialog(ApplicationController.getStage());
        if (f != null)
        {
            try(FileInputStream stream = new FileInputStream(f))
            {
                Scanner scanner = new Scanner(stream);
                StringBuilder builder = new StringBuilder("");
                while (scanner.hasNext()) {
                    builder.append(scanner.nextLine());
                    builder.append('\n');
                }
                code.setText(builder.toString());
            }
            catch (IOException e)
            {
                log.setText("Could not open the file...");
            }
        }
    }

    static MainWindowController create() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainWindowController.class.getResource("MainWindow.fxml"));
        loader.load();
        return loader.getController();
    }
}
