package main.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class ApplicationController extends Application {
    private static PrintStream out;
    private static Stage stage;
    public static final String path = "last.code";

    static Stage getStage(){return stage;}
    public static PrintStream getOutput() {
        return out;
    }
    private MainWindowController controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        controller = MainWindowController.create(loadCode());
        out = new PrintStream(controller.getOutputStream());
        primaryStage.setScene(new Scene(controller.getRoot()));
        primaryStage.setTitle("My Language Compiler");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @Override
    public void stop() {
        try(OutputStreamWriter stream = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(path))))
        {
            stream.write(controller.getCode());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public String loadCode()
    {
        File f = new File(path);
        if (!f.exists())
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        try(Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(f))))
        {
            StringBuilder b = new StringBuilder();
            while (scanner.hasNext()) {
                b.append(scanner.nextLine());
                b.append("\n");
            }
            return b.toString();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String... args)
    {
        launch(args);
    }
}
