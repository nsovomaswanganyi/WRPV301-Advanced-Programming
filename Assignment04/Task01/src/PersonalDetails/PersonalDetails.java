package PersonalDetails;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/// DO NOT RUN THIS CLASS, USE THE RunPersonalDetails CLASS TO RUN!!!
/// This ensures that you don't have to include VM options each and everytime
public class PersonalDetails extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();

        Scene scene = new Scene(root,200,250);

        stage.setScene(scene);
        stage.setTitle("Personal Details");
        stage.show();
    }

    /// DO NOT RUN THIS CLASS, USE THE RunPersonalDetails CLASS TO RUN!!!
    public static void main(String[] args) {
        launch(args);
    }
}
