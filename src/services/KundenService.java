package services;

import model.Kunde;

import java.util.ArrayList;
import java.util.List;

public class KundenService {
    private List<Kunde> kundenListe;

    public KundenService() {
        this.kundenListe = new ArrayList<>();
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

    //Methoden zum Ändern von Kundendaten




}
