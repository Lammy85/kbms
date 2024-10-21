package model;

public class Kunde {

    //Eigenschaften

    private String vorname;
    private String nachname;
    private int kundennummer;
    private String strasse;
    private int hausnummer;
    private int plz;
    private String wohnort;

    //Konstruktor

    public Kunde(String vorname, String nachname, int kundennummer, String strasse, int hausnummer, int plz, String wohnort) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.kundennummer = kundennummer;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.plz = plz;
        this.wohnort = wohnort;
    }

    //Getter und Setter

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public int getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(int kundennummer) {
        this.kundennummer = kundennummer;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public int getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(int hausnummer) {
        this.hausnummer = hausnummer;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getWohnort() {
        return wohnort;
    }

    public void setWohnort(String wohnort) {
        this.wohnort = wohnort;
    }

    //toString()-Methode
    //@Override
    //public String toString() {
    //}
}
