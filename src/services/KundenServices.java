package services;

import model.Kunde;

import java.util.ArrayList;
import java.util.List;

public class KundenServices {
    private List<Kunde> kundenListe;

    public KundenServices() {
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


}
