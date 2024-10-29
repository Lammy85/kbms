package services;

import model.Bestellung;
import repos.BestellungRepo;

import java.util.List;

public class BestellungService {
    private final BestellungRepo repository;

    public BestellungService() {
        this.repository = new BestellungRepo("store.db");
    }

    //Methode zum Hinzufügen einer Bestellung

    public void bestellungHinzufuegen(Bestellung bestellung) {
        repository.bestellungHinzufuegen(bestellung);
        System.out.println("Bestellung hinzugefuegt: " + bestellung.getBestellnummer());
    }

    //Getter für die Bestell-Liste

    public List<Bestellung> getBestellungListe() {
        return repository.getBestellungen();
    }

    public void bestellungBezahlt(int bestellnummer) {
        repository.bestellungBezahlt(bestellnummer);
        System.out.println("Bestellung als Bezahlt markiert: " + bestellnummer);
    }

    // Methode Bestellung löschen
    public void bestellungLoeschen(int bestellnummer) {
        repository.bestellungLoeschen(bestellnummer);
        System.out.println("Bestellung gelöscht: " + bestellnummer);
    }

    public void close() {
        repository.close();
    }
}

