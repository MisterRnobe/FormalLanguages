package main.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.PrintStream;

public class ApplicationController extends Application {
    private static PrintStream out;
    private static Stage stage;

    public static Stage getStage(){return stage;}
    public static PrintStream getOutput() {
        return out;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
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
