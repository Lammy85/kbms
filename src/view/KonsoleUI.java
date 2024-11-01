package view;

import model.Bestellung;
import model.Kunde;
import services.BestellungService;
import services.KundenService;

import java.util.Scanner;

public class KonsoleUI {

    //Variablen für die Objekte

    private BestellungService bestellungService;
    private KundenService kundenService;
    private Scanner scanner;

    public KonsoleUI() {

        //Erstellung der Objekte und des Scanners mit der Bezeichnung scanner

        bestellungService = new BestellungService();
        kundenService = new KundenService();
        scanner = new Scanner(System.in);
    }

    //Ausführung der Hauptmenü-Optionen

    public void start() {
        boolean run = true;
        while (run) {
            hauptmenue();
            int wahl = scanner.nextInt();
            scanner.nextLine();
            switch (wahl) {
                case 0:
                    System.out.println("Bis zum nächsten Mal.");
                    run = false;
                    break;
                case 1:
                    kundeHinzufuegenUI();
                    break;
                case 2:
                    bestellungHinzufuegenUI();
                    break;
                case 3:
                    bestellungenAnzeigenUI();
                    break;
                case 4:
                    kundenAnzeigenUI();
                    break;
                case 5:
                    bestellungLoeschenUI();
                    break;
                default:
                    System.out.println("Ungültige Wahl");
            }
        }
    }

    //Das Hauptmenü

    private void hauptmenue() {
        System.out.println("\n*****KBMS*****");
        System.out.println("1. Kunden hinzufügen");
        System.out.println("2. Bestellung hinzufügen");
        System.out.println("3. Bestellungen anzeigen");
        System.out.println("4. Kunden anzeigen");
        System.out.println("5. Bestellung löschen");
        System.out.println("0. Beenden");
        System.out.print("Auswahl: ");
    }

    //Methode zum Hinzufügen einer neuen Bestellung

    private void bestellungHinzufuegenUI() {
        System.out.print("Bestellnummer: ");
        int bestellnummer = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Produkt: ");
        String produkt = scanner.nextLine();
        System.out.print("Stückzahl: ");
        int stueckzahl = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Betrag: ");
        double betrag = scanner.nextDouble();
        scanner.nextLine();

        Bestellung bestellung = new Bestellung(bestellnummer, produkt, stueckzahl, betrag);
        bestellungService.bestellungHinzufuegen(bestellung);
    }

    //Methode zum Anzeigen der Bestellungen

    private void bestellungenAnzeigenUI() {
        System.out.println("\n-------Bestellungen----------");
        System.out.printf("%-15s | %-15s | %-15s | %-15s | %-15s | %s\n", "Bestellnummer", "Produkt", "Stückzahl", "Betrag EUR", "Zahlungsstatus", "Lieferstatus");
        System.out.println("-------------------------------------------------------------------");
        for (Bestellung bestellung : bestellungService.getBestellungListe()) {
            System.out.println(bestellung);
        }
    }

    private void kundenAnzeigenUI() {
        System.out.println("\n-------Kunden----------");
        System.out.printf("%-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %s\n", "Vorname", "Nachname", "Kundennummer", "Straße", "Hausnummer", "Postleitzahl", "Wohnort");
        System.out.println("-------------------------------------------------------------------");
        for (Kunde kunde : kundenService.getKundenListe()) {
            System.out.println(kunde);
        }
    }

    //Methode zum Hinzufügen neuer Kunden

    private void kundeHinzufuegenUI() {
        System.out.print("Vorname: ");
        String vorname = scanner.nextLine();
        System.out.print("Nachname: ");
        String nachname = scanner.nextLine();
        System.out.print("Kundennummer: ");
        int kundennummer = scanner.nextInt();
        System.out.print("Straße: ");
        scanner.nextLine();
        String strasse = scanner.nextLine();
        System.out.print("Hausnummer: ");
        int hausnummer = scanner.nextInt();
        System.out.print("Postleitzahl: ");
        int plz = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Wohnort: ");
        String wohnort = scanner.nextLine();

        Kunde kunde = new Kunde(vorname, nachname, kundennummer, strasse, hausnummer, plz, wohnort);
        kundenService.kundeHinzufuegen(kunde);

    }
    private void bestellungLoeschenUI() {
        System.out.print("Bestellnummer der zu löschenden Bestellung: ");
        int bestellnummer = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Sind Sie sicher, dass Sie die Bestellung löschen möchten? (j/n): ");
        String bestaetigung = scanner.nextLine();
        if (bestaetigung.equalsIgnoreCase("j")) {
            bestellungService.bestellungLoeschen(bestellnummer);
        } else {
            System.out.println("Löschvorgang abgebrochen.");
        }
    }
}
