package main.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.PrintStream;

public class ApplicationController extends Application {
    private static PrintStream out;

    public static PrintStream getOut() {
        return out;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainWindowController controller = MainWindowController.create();
        out = new PrintStream(controller.getOutputStream());
        primaryStage.setScene(new Scene(controller.getRoot()));
        primaryStage.setTitle("My Language Compiler");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String... args)
    {
        launch(args);
    }
}
