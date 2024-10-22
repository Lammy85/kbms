package services;

import model.Bestellung;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BestellungService {
    private List<Bestellung> bestellungListe;
    private static final String BESTELLDATEI = "data/Testliste.txt";

    public BestellungService() {
        this.bestellungListe = new ArrayList<>();
    }

    //Methode zum Hinzufügen einer Bestellung

    public void bestellungHinzufuegen(Bestellung bestellung) {
        bestellungListe.add(bestellung);
        System.out.println("Bestellung hinzugefuegt: " + bestellung.getBestellnummer());
    }

    //Getter für die Bestell-Liste

    public List<Bestellung> getBestellungListe() {
        return bestellungListe;
    }

    //Bestellung in Textdatei speichern

    public void bestellungSpeichern() {
        try {
            File dateiB = new File(BESTELLDATEI);
            File verzeichnis = dateiB.getParentFile();

            if (verzeichnis != null && !verzeichnis.exists()) {
                //neues Verzeichnis erstellen
                verzeichnis.mkdir();
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dateiB))) {
                oos.writeObject(bestellungListe);
                System.out.println("Daten wurden erfolfgeich gespeichert.");
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Speichern der Daten: " + e.getMessage());
        }
    }

    //Bestellung in Textdatei laden

    private void bestellungLaden() {
        File dateiB = new File(BESTELLDATEI);
        if (dateiB.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dateiB))) {
                bestellungListe = (List<Bestellung>) ois.readObject();
                System.out.println("Daten wurden erfolgreich geladen.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Fehler beim Laden der Daten: " + e.getMessage());
            }
        } else {
            System.out.println("Keine Daten zum Laden gefunden.");
        }
    }
}

