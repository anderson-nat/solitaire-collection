package main.java.application;

import javafx.application.Application;
import javafx.stage.Stage;
import main.java.windows.Menu;

/**
 * Main class of the project that groups together everything else and actually launches the application
 *
 * @author Nat Anderson
 * Date Last Modified: 2021-08-12
 */
public class Main extends Application {

    /**
     * Required method by Application class.
     * Similar purpose as main method in normal Java project
     * @param stage : The window that will be created by the application
     */
    public void start(Stage stage) {

        Menu menu = new Menu();

        stage.setScene(menu.getScene());
        stage.setTitle("Solitaire Collection");
        stage.show();

    }

    /**
     * Launches the application with any command-line arguments present.
     * @param args : Command-line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
