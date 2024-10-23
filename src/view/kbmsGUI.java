package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.Bestellung;
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

        Button viewKunden = new Button("Kunden anzeigen");
        viewKunden.setOnAction(e -> showKundenListeView());

        Button addBestellung = new Button("Bestellung hinzufügen");
        addBestellung.setOnAction(e -> showAddBestellung());

        Button viewBestellung = new Button("Bestellungen anzeigen");
        viewBestellung.setOnAction(e -> showBestellListeView());

        //Knöpfe werden hier eingefügt

        kiste.getChildren().addAll(titleLabel, addKunde, viewKunden, addBestellung, viewBestellung);

        Scene scene = new Scene(kiste, 600, 600);
        buehne.setTitle("KBMS - Hauptmenü");
        buehne.setScene(scene);
        buehne.show();
    }

    //Kunden hinzufügen

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

        HBox buttonBox = new HBox(10, addButton, cancelButton);

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

        Scene scene = new Scene(kiste, 600, 600);
        buehne.setTitle("Kunde hinzufügen");
        buehne.setScene(scene);
        buehne.show();
    }

    //Bestellungen hinzufügen

    private void showAddBestellung() {

        //Layout

        VBox kiste = new VBox(20);
        kiste.setPadding(new Insets(20));

        //Inputs

        TextField bestnrFeld = new TextField();
        bestnrFeld.setPromptText("Bestellnummer");

        TextField produktFeld = new TextField();
        produktFeld.setPromptText("Produktbezeichnung");

        TextField stkFeld = new TextField();
        stkFeld.setPromptText("Stückzahl");

        TextField betragFeld = new TextField();
        betragFeld.setPromptText("Betrag EUR");


        //Bestellung hinzufügen button

        Button addButton = new Button("Bestellung hinzufügen");
        addButton.setOnAction(e -> {

            int bestellnummer = Integer.parseInt(bestnrFeld.getText());
            String produkt = produktFeld.getText();
            int stueckzahl = Integer.parseInt(stkFeld.getText());
            float betrag = Float.parseFloat(betragFeld.getText());


            if (bestellnummer <= 0) {
                showAlert("Fehler", "Bitte gültige Bestellnummer vergeben");
                return;
            }

            Bestellung bestellung = new Bestellung(bestellnummer, produkt, stueckzahl, betrag);
            bestellungService.bestellungHinzufuegen(bestellung);

            showAlert("Erfolg", "Bestellung hinzugefügt");

            //Zurück zum Hauptmenü

            showHauptmenue();
        });

        Button cancelButton = new Button("Abbrechen");
        cancelButton.setOnAction(e -> showHauptmenue());

        HBox buttonBox = new HBox(10, addButton, cancelButton);

        kiste.getChildren().addAll(
                new Label("Neue Bestellung hinzufügen"),
                bestnrFeld,
                produktFeld,
                stkFeld,
                betragFeld,
                buttonBox
        );

        Scene scene = new Scene(kiste, 600, 600);
        buehne.setTitle("Bestellung hinzufügen");
        buehne.setScene(scene);
        buehne.show();
    }

    private void showKundenListeView() {
        //Layout
        VBox kiste = new VBox(20);
        kiste.setPadding(new Insets(20));

        //Tabellenansicht für die Kunden

        TableView<Kunde> tableView = new TableView<>();

        //Colums

        TableColumn<Kunde, String> vornameColumn = new TableColumn<>("Vorname");
        vornameColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getVorname()));

        TableColumn<Kunde, String> nachnameColumn = new TableColumn<>("Nachname");
        nachnameColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getNachname()));

        TableColumn<Kunde, String> knrColumn = new TableColumn<>("Kundennummer");
        knrColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(String.valueOf(cellData.getValue().getKundennummer())));

        TableColumn<Kunde, String> strColumn = new TableColumn<>("Straße");
        strColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getStrasse()));

        TableColumn<Kunde, String> hsnrColumn = new TableColumn<>("Hausnummer");
        hsnrColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(String.valueOf(cellData.getValue().getHausnummer())));

        TableColumn<Kunde, String> plzColumn = new TableColumn<>("Postleitzahl");
        plzColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(String.valueOf(cellData.getValue().getPlz())));

        TableColumn<Kunde, String> ortColumn = new TableColumn<>("Wohnort");
        ortColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getWohnort()));

        tableView.getColumns().addAll(vornameColumn, nachnameColumn, knrColumn, strColumn, hsnrColumn, plzColumn, ortColumn);

        //Daten laden
        tableView.getItems().addAll(kundenService.getKundenListe());

        //Buttons

        Button zurueckButton = new Button("Zurück zum Hauptmenü");
        zurueckButton.setOnAction(e -> showHauptmenue());

        HBox buttonBox = new HBox(10, zurueckButton);

        //Anzeigen

        kiste.getChildren().addAll(new Label("Alle Kunden"), tableView, buttonBox);

        Scene scene = new Scene(kiste, 600, 600);
        buehne.setTitle("Kundenliste anzeigen");
        buehne.setScene(scene);
        buehne.show();

    }

    private void showBestellListeView() {
        //Layout
        VBox kiste = new VBox(20);
        kiste.setPadding(new Insets(20));

        //Tabellenansicht für die Bestellungen

        TableView<Bestellung> tableView = new TableView<>();

        //Colums

        TableColumn<Bestellung, String> bestnrColumn = new TableColumn<>("Bestellnummer");
        bestnrColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(String.valueOf(cellData.getValue().getBestellnummer())));

        TableColumn<Bestellung, String> produktColumn = new TableColumn<>("Produktbezeichnung");
        produktColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getProdukt()));

        TableColumn<Bestellung, String> stkzahlColumn = new TableColumn<>("Stückzahl");
        stkzahlColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(String.valueOf(cellData.getValue().getStueckzahl())));

        TableColumn<Bestellung, String> betragColumn = new TableColumn<>("Betrag EUR");
        betragColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(String.valueOf(cellData.getValue().getBetrag())));

        TableColumn<Bestellung, String> bezahltColumn = new TableColumn<>("Zahlungsstatus");
        bezahltColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(
                cellData.getValue().isBezahlt() ? "Bezahlt" : "Offen"
                ));

        TableColumn<Bestellung, String> lieferstatusColumn = new TableColumn<>("Lieferstatus");
        lieferstatusColumn.setCellValueFactory(cellData -> {
            int status = cellData.getValue().getLieferstatus();
            String statusText = switch (status) {
                case 1 -> "Noch nicht versandt";
                case 2 -> "Auf dem Versandweg";
                case 3 -> "Beim Kunden eingetroffen";
                default -> "Unbekannt";
            };
            return new javafx.beans.property.SimpleStringProperty(statusText);
        });

        tableView.getColumns().addAll(bestnrColumn, produktColumn, stkzahlColumn, betragColumn, bezahltColumn);

        //Daten laden
        tableView.getItems().addAll(bestellungService.getBestellungListe());

        //Buttons

        Button zurueckButton = new Button("Zurück zum Hauptmenü");
        zurueckButton.setOnAction(e -> showHauptmenue());

        HBox buttonBox = new HBox(10, zurueckButton);

        //Anzeigen

        kiste.getChildren().addAll(new Label("Alle Bestellungen"), tableView, buttonBox);

        Scene scene = new Scene(kiste, 600, 400);
        buehne.setTitle("Bestellungen anzeigen");
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

    //Speichern der Listen bei Beendigung des Programms

    @Override
    public void stop() throws Exception {
        kundenService.kundenSpeichern();
        bestellungService.bestellungSpeichern();
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
