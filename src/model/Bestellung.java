package model;

public class Bestellung {

    //Eigenschaften

    private int bestellnummer;
    private String produkt;
    private int stueckzahl;
    private double betrag;
    private boolean bezahlt;
    private int lieferstatus; //z.B. 1 = noch nicht versandt 2 = auf dem Versandweg 3 = Beim Kunden eingetroffen

    //Konstruktor

    public Bestellung(int bestellnummer, String produkt, int stueckzahl, double betrag) {
        this.bestellnummer = bestellnummer;
        this.produkt = produkt;
        this.stueckzahl = stueckzahl;
        this.betrag = betrag;
        this.bezahlt = false;
        this.lieferstatus = 1;
    }

    //Getter und Setter


    public int getBestellnummer() {
        return bestellnummer;
    }

    public void setBestellnummer(int bestellnummer) {
        this.bestellnummer = bestellnummer;
    }

    public String getProdukt() {
        return produkt;
    }

    public void setProdukt(String produkt) {
        this.produkt = produkt;
    }

    public int getStueckzahl() {
        return stueckzahl;
    }

    public void setStueckzahl(int stueckzahl) {
        this.stueckzahl = stueckzahl;
    }

    public double getBetrag() {
        return betrag;
    }

    public void setBetrag(double betrag) {
        this.betrag = betrag;
    }

    public boolean isBezahlt() {
        return bezahlt;
    }

    public void setBezahlt(boolean bezahlt) {
        this.bezahlt = bezahlt;
    }

    public int getLieferstatus() {
        return lieferstatus;
    }

    public void setLieferstatus(int lieferstatus) {
        this.lieferstatus = lieferstatus;
    }

    //toString()-Methode
    @Override
    public String toString() {
        String status = bezahlt ? "Bezahlt" : "Nicht Bezahlt";
        String lieferung;
        switch (lieferstatus) {
            case 1:
                lieferung = "Noch nicht versandt";
                break;
            case 2:
                lieferung = "Auf dem Versandweg";
                break;
            case 3:
                lieferung = "Beim Kunden eingetroffen";
                break;
            default:
                lieferung = "Unbekannt";
        }
        return String.format("%-10s | %-10s | %-10s | %-10s | %-10s | %s", bestellnummer, produkt, stueckzahl, betrag, status, lieferung);
    }
}
