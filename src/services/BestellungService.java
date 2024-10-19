package services;

import model.Bestellung;

import java.util.ArrayList;
import java.util.List;

public class BestellungService {
    private List<Bestellung> bestellungList;

    public BestellungService() { this.bestellungList = new ArrayList<>(); }

    //Methode zum Hinzufügen einer Bestellung
    public void bestellungHinzufuegen(Bestellung bestellung){
        bestellungList.add(bestellung);
        System.out.println("Bestellung hinzugefuegt: " + bestellung.getBestellnummer());
    }

    public List<Bestellung> getBestellungList() {
        return bestellungList;
    }
}
