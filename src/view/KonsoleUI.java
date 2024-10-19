package view;

import model.Bestellung;
import services.BestellungService;

import java.sql.SQLOutput;
import java.util.Scanner;

public class KonsoleUI {
    private BestellungService bestellungService;
    private Scanner scanner;

    public KonsoleUI() {
        bestellungService = new BestellungService();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean run = true;
        while (run) {
            hauptmenue();
            int wahl = scanner.nextInt();
            scanner.nextLine();
            switch (wahl) {
                case 0:
                    run = false;
                    break;
                case 2:
                    bestellungHinzufuegenUI();
                    break;
                case 3:
                    bestellungenAnzeigenUI();
                    break;
                default:
                    System.out.println("Ungültige Wahl");
            }


        }

    }

    private void hauptmenue() {
        System.out.println("\n*****KBMS*****");
        //System.out.println("1. Kunden anzeigen");
        System.out.println("2. Bestellung hinzufügen");
        System.out.println("3. Bestellungen anzeigen");
        //System.out.println("3. Neuer Kunde");
        System.out.println("0. Beenden");
        System.out.print("Auswahl: ");
    }

    private void bestellungHinzufuegenUI() {
        System.out.print("Bestellnummer: ");
        int bestellnummer = scanner.nextInt();
        System.out.print("Produkt: ");
        String produkt = scanner.nextLine();
        System.out.print("Stückzahl: ");
        int stueckzahl = scanner.nextInt();
        System.out.print("Betrag: ");
        double betrag = scanner.nextDouble();
        scanner.nextLine();

        Bestellung bestellung = new Bestellung(bestellnummer, produkt, stueckzahl, betrag);
        bestellungService.bestellungHinzufuegen(bestellung);
    }

    private void bestellungenAnzeigenUI() {
        System.out.println("\n-------Bestellungen----------");
        System.out.printf("%-10s | %-10s | %-10s | %-10s | %-10s | %s\n", "Bestellnummer", "Produkt", "Stückzahl", "Betrag", "Zahlungsstatus", "Lieferstatus");
        System.out.println("-------------------------------------------------------------------");
        for (Bestellung bestellung : bestellungService.getBestellungList()) {
            System.out.println(bestellung);
        }
    }


}
