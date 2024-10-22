package services;

import model.Bestellung;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BestellungService {
    private List<Bestellung> bestellungListe;
    private static final String BESTELLDATEI = "data/BestellListe.txt";

    public BestellungService() {
        this.bestellungListe = new ArrayList<>();
        bestellungLaden();
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
            File datei = new File(BESTELLDATEI);
            File verzeichnis = datei.getParentFile();

            if (verzeichnis != null && !verzeichnis.exists()) {
                //neues Verzeichnis erstellen
                verzeichnis.mkdirs();
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(datei))) {
                oos.writeObject(bestellungListe);
                System.out.println("Bestelldaten wurden erfolfgeich gespeichert.");
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Speichern der Bestelldaten: " + e.getMessage());
        }
    }

    //Bestellung in Textdatei laden

    private void bestellungLaden() {
        File datei = new File(BESTELLDATEI);
        if (datei.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(datei))) {
                bestellungListe = (List<Bestellung>) ois.readObject();
                System.out.println("Bestelldaten wurden erfolgreich geladen.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Fehler beim Laden der Bestelldaten: " + e.getMessage());
            }
        } else {
            System.out.println("Keine Bestelldaten zum Laden gefunden.");
        }
    }
}

