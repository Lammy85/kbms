package view;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class kbmsGUI extends Application {
    Stage buehne;
    @Override
    public void start(Stage stage) throws Exception {
        this.buehne = stage;
        VBox kiste = new VBox(20);
        kiste.setPadding(new Insets(20));
        Scene screen = new Scene(kiste,400,500);
        buehne.setScene(screen);
        buehne.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
