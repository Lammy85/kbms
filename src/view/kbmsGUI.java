package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.Kunde;
import services.BestellungService;
import services.KundenService;

public class kbmsGUI extends Application {

    private BestellungService bestellungService;
    private KundenService kundenService;
    private Stage buehne;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.buehne = primaryStage;
        bestellungService = new BestellungService();
        kundenService = new KundenService();

        showHauptmenue();
    }

    private void showHauptmenue() {

        //Layout

        VBox kiste = new VBox(20);
        kiste.setPadding(new Insets(20));

        Label titleLabel = new Label("KBMS");

        Button addKunde = new Button("Kunde hinzufügen");
        addKunde.setOnAction(e -> showAddKunde());

        Button addBestellung = new Button("Bestellung hinzufügen");
        addBestellung.setOnAction(e -> showAddBestellung());

        kiste.getChildren().addAll(titleLabel, addKunde, addBestellung);

        Scene scene = new Scene(kiste, 300, 200);
        buehne.setTitle("KBMS - Hauptmenü");
        buehne.setScene(scene);
        buehne.show();
    }

    private void showAddKunde() {

        //Layout

        VBox kiste = new VBox(20);
        kiste.setPadding(new Insets(20));

        //Inputs

        TextField vornameFeld = new TextField();
        vornameFeld.setPromptText("Vorname des Kunden eingeben");

        TextField nachnameFeld = new TextField();
        nachnameFeld.setPromptText("Nachname des Kunden eingeben");

        TextField knrFeld = new TextField();
        knrFeld.setPromptText("Kundennummer eingeben");

        TextField strasseFeld = new TextField();
        strasseFeld.setPromptText("Strasse des Kunden eingeben");

        TextField hausnummerFeld = new TextField();
        hausnummerFeld.setPromptText("Hausnummer des Kunden eingeben");

        TextField plzFeld = new TextField();
        plzFeld.setPromptText("Postleitzahl des Kunden eingeben");

        TextField ortFeld = new TextField();
        ortFeld.setPromptText("Wohnort des Kunden eingeben");

        //Kunde hinzufügen button

        Button addButton = new Button("Kunde hinzufügen");
        addButton.setOnAction(e -> {
            String vorname = vornameFeld.getText();
            String nachname = nachnameFeld.getText();
            int kundennummer = Integer.parseInt(knrFeld.getText());
            String strasse = strasseFeld.getText();
            int hausnummer = Integer.parseInt(hausnummerFeld.getText());
            int plz = Integer.parseInt(plzFeld.getText());
            String wohnort = ortFeld.getText();

            if (kundennummer <= 0) {
                showAlert("Fehler", "Bitte gültige Kundennummer vergeben");
                return;
            }

            Kunde kunde = new Kunde(vorname, nachname, kundennummer, strasse, hausnummer, plz, wohnort);
            kundenService.kundeHinzufuegen(kunde);

            showAlert("Erfolg", "Kunde hinzugefügt");

            //Zurück zum Hauptmenü

            showHauptmenue();
        });

        Button cancelButton = new Button("Abbrechen");
        cancelButton.setOnAction(e -> showHauptmenue());

        HBox buttonBox = new HBox(10,addButton,cancelButton);

        kiste.getChildren().addAll(
                new Label("Neuen Kunden hinzufügen"),
                vornameFeld,
                nachnameFeld,
                knrFeld,
                strasseFeld,
                hausnummerFeld,
                plzFeld,
                ortFeld,
                buttonBox
        );

        Scene scene = new Scene(kiste,400,400);
        buehne.setTitle("Kunde hinzufügen");
        buehne.setScene(scene);
        buehne.show();
    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showAddBestellung() {

    }

    @Override
    public void stop() throws Exception {
        kundenService.kundenSpeichern();
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
