Projekt 3: Kunden- und Bestellmanagement
Übersicht

Dieses Projekt ist ein Verwaltungssystem für Kunden und Bestellungen, das die grundlegenden Funktionen für das Hinzufügen, Anzeigen, Erstellen und Bearbeiten von Kunden und Bestellungen umfasst. Alle Daten werden persistiert, sodass sie auch nach dem Neustart der Anwendung erhalten bleiben.
Hauptfunktionen

    Kunden hinzufügen
        Funktion: Ermöglicht das Hinzufügen neuer Kunden in das System.
        Details:
            Eingabe: Kundeninformationen wie Name, Adresse, Wohnort, Kundennummer.
            Validierung: Überprüfung der eingegebenen Daten auf Korrektheit. (geplant)
            Speicherung: Speichert die Kundendaten in der Datenbank.

    Kunden anzeigen
        Funktion: Zeigt alle im System gespeicherten Kunden an.
        Details:
            Such- und Filteroptionen, z. B. nach Name oder ID (geplant, aber noch nicht umgesetzt).
            Ausgabe in einer strukturierten Ansicht, ggf. tabellarisch mit den wichtigsten Kundeninformationen.

    Bestellungen erstellen
        Funktion: Ermöglicht das Erstellen einer neuen Bestellung für einen bestehenden Kunden.
        Details:
            Eingabe: Details zur Bestellung, wie Produktname, Menge, Preis und Bestellnummer.
            Validierung: Überprüfung der eingegebenen Daten auf Korrektheit. (geplant)
            Speicherung: Speichert die Bestelldaten in der Datenbank (Verknüpfung mit Kunden ist geplant).

    Bestellungen anzeigen
        Funktion: Zeigt alle Bestellungen an (mit der Möglichkeit, nach bestimmten Kriterien zu filtern ist geplant).
        Details:
            Filtermöglichkeiten, z. B. nach Kunde, Datum oder Status der Bestellung (z. B. in Bearbeitung, abgeschlossen).
            Ausgabe in einer strukturierten Ansicht, ggf. tabellarisch mit den wichtigsten Bestellinformationen.
            Möglichkeit, den Status der Bestellung oder das zugehörige Kundenprofil anzuzeigen.

    Bestellungen bearbeiten (geplant)
        Funktion: Ermöglicht die Bearbeitung bestehender Bestellungen.
        Details:
            Bearbeitbare Felder umfassen u. a. Produktmenge, Lieferdatum und Status der Bestellung.
            Validierung: Überprüfung der eingegebenen Änderungen auf Korrektheit. (geplant)
            Speicherung: Speichert die aktualisierten Bestelldaten in der Datenbank.

    Datenpersistenz
        Funktion: Sichert alle Daten zu Kunden und Bestellungen dauerhaft, sodass sie auch nach Schließen der Anwendung erhalten bleiben.
        Details:
            Speichert die Daten in einer Datenbank (SQLite).

Technische Anforderungen

    Programmiersprache: (Java)
    Speicheroptionen: Verwendung einer SQLite-Datenbank oder JSON-Dateien für Datenpersistenz.
    Benutzeroberfläche: Grafische Benutzeroberfläche (GUI mit Javafx) oder eine einfache Konsolenanwendung.
    Fehlermanagement: Umgang mit Fehlern, wie z. B. unvollständigen Eingaben, ungültigen Kundennummern oder fehlgeschlagener Verbindung zur Datenbank.(geplant)

Benutzerrollen und Berechtigungen (geplant)
    
    Admin: Kann alle Funktionen nutzen, inklusive dem Bearbeiten und Löschen von Bestellungen.
    Mitarbeiter: Kann nur Kunden- und Bestellinformationen anzeigen und neue Kunden sowie Bestellungen hinzufügen.

Ausblick und Erweiterungen

    Erweiterte Suche: Hinzufügen einer detaillierten Such- und Filterfunktion für Kunden und Bestellungen.
    Export- und Importfunktion: Exportieren und Importieren von Kundendaten und Bestellungen als CSV/Excel.
    Benachrichtigungssystem: Hinzufügen von Benachrichtigungen für Kunden über den Status ihrer Bestellungen.
    Berichterstellung: Erstellung von Berichten für Umsatz, Anzahl Bestellungen und Kundenaktivität.

Diese Dokumentation soll als Ausgangspunkt für die Entwicklung des Kunden- und Bestellmanagementsystems dienen und die grundlegenden Anforderungen und Funktionen festlegen.
