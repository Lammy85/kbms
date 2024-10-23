package services;

import model.Bestellung;
import model.Kunde;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class KundenService {

    private List<Kunde> kundenListe;
    private static final String KUNDENDATEI = "data/Kundenliste.txt";

    public KundenService() {
        this.kundenListe = new ArrayList<>();
        kundenLaden();
    }

    //Methode zum Hinzufügen neuer Kunden
    public void kundeHinzufuegen(Kunde kunde) {
        kundenListe.add(kunde);
        System.out.println("Kunde hinzugefügt: " + kunde.getKundennummer());
    }

    //Getter für die Kundenliste

    public List<Kunde> getKundenListe() {
        return kundenListe;
    }

    //Kunden in Textdatei speichern

    public void kundenSpeichern() {
        try {
            File dateiB = new File(KUNDENDATEI);
            File verzeichnis = dateiB.getParentFile();

            if (verzeichnis != null && !verzeichnis.exists()) {
                //neues Verzeichnis erstellen
                verzeichnis.mkdir();
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dateiB))) {
                oos.writeObject(kundenListe);
                System.out.println("Kundendaten wurden erfolfgeich gespeichert.");
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Speichern der Kundendaten: " + e.getMessage());
        }
    }

    //Kunden in Textdatei laden

    private void kundenLaden() {
        File datei = new File(KUNDENDATEI);
        if (datei.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(datei))) {
                kundenListe = (List<Kunde>) ois.readObject();
                System.out.println("Kundendaten wurden erfolgreich geladen.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Fehler beim Laden der Kundendaten: " + e.getMessage());
            }
        } else {
            System.out.println("Keine Kundendaten zum Laden gefunden.");
        }
    }

    // Methode Kunden löschen
    public boolean kundenLoeschen(int kundennummer) {
        for (int i = 0; i < kundenListe.size(); i++) {
            Kunde kunde = kundenListe.get(i);
            if (kunde.getKundennummer() == (kundennummer)) {
                kundenListe.remove(i);
                System.out.println("Kunde gelöscht: " + kundennummer);
                return true;
            }
        }
        System.out.println("Kundennummer nicht gefunden: " + kundennummer);
        return false;
    }
}
