package main.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextFormatter;
import javafx.stage.FileChooser;
import main.language.Runner;

import java.io.*;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class MainWindowController {
    @FXML
    private TextArea code;
    @FXML
    private Parent root;
    @FXML
    private TextArea log;
    private int tabs = 0;


    @FXML
    private void run() {
        log.setText("");
        Runner.run(code.getText());
    }
    public String getCode()
    {
        return code.getText();
    }

    @FXML
    private void initialize() {
//        UnaryOperator<TextFormatter.Change> operator = change -> {
//            if (change.isAdded())
//            {
//                if (change.getText().length() == 1 & change.getText().charAt(0) == 10) {
//                    change.setText((char)10+"\t");
//                    //change.setCaretPosition(change.getCaretPosition()+1);
//                    code.positionCaret(change.getControlCaretPosition()+2);
//                    change.setCaretPosition(change.getControlText().length());
//                    //System.out.println(change.getCaretPosition());
//                }
//
//                    //change.setText("\n\t");
//            }
//            //System.out.println((int)change.getText().charAt(0));
//            return change;
//        };
//        code.setTextFormatter(new TextFormatter<>(operator));
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
    public void setCode(String code)
    {
        this.code.setText(code);
    }

    static MainWindowController create(String code) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainWindowController.class.getResource("MainWindow.fxml"));
        loader.load();
        MainWindowController c = loader.getController();
        if (code!=null)
            c.setCode(code);
        return c;
    }
}
