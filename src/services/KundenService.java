package services;

import model.Kunde;
import repos.KundeRepo;

import java.util.List;

public class KundenService {
    private final KundeRepo repository;

    public KundenService() {
        this.repository = new KundeRepo("database/store.db");
    }

    //Methode zum Hinzufügen neuer Kunden

    public void kundeHinzufuegen(Kunde kunde) {
        repository.kundeHinzufuegen(kunde);
        System.out.println("Kunde hinzugefügt: " + kunde.getKundennummer());
    }

    //Getter für die Kundenliste

    public List<Kunde> getKundenListe() {
        return repository.getKunde();
    }

// Methode Kunden löschen

    public void kundenLoeschen(int kundennummer) {
        repository.kundeLoeschen(kundennummer);
    }

    public void close() {
        repository.close();
    }
}

