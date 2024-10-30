Projekt 3: Kunden- und Bestellmanagement
Übersicht

Dieses Projekt ist ein Verwaltungssystem für Kunden und Bestellungen, das die grundlegenden Funktionen für das Hinzufügen, Anzeigen, Erstellen und Bearbeiten von Kunden und Bestellungen umfasst. Alle Daten werden persistiert, sodass sie auch nach dem Neustart der Anwendung erhalten bleiben.
Hauptfunktionen

    Kunden hinzufügen
        Funktion: Ermöglicht das Hinzufügen neuer Kunden in das System.
        Details:
            Eingabe: Kundeninformationen wie Name, Adresse, Telefonnummer und E-Mail.
            Validierung: Überprüft, ob alle Pflichtfelder (z. B. Name, Telefonnummer) korrekt ausgefüllt sind.
            Speicherung: Speichert die Kundendaten in der Datenbank oder einer externen Datei.

    Kunden anzeigen
        Funktion: Zeigt alle im System gespeicherten Kunden an.
        Details:
            Such- und Filteroptionen, z. B. nach Name oder ID.
            Ausgabe in einer strukturierten Ansicht, ggf. tabellarisch mit den wichtigsten Kundeninformationen.
            Ermöglicht das Abrufen einzelner Kundenprofile.

    Bestellungen erstellen
        Funktion: Ermöglicht das Erstellen einer neuen Bestellung für einen bestehenden Kunden.
        Details:
            Eingabe: Auswahl des Kunden sowie Details zur Bestellung, wie Produktname, Menge, Preis und Lieferdatum.
            Validierung: Stellt sicher, dass alle Eingaben (z. B. Produktverfügbarkeit) korrekt sind und der ausgewählte Kunde im System existiert.
            Speicherung: Speichert die Bestelldaten in der Datenbank oder externen Datei und verknüpft sie mit dem entsprechenden Kunden.

    Bestellungen anzeigen
        Funktion: Zeigt alle Bestellungen an, mit der Möglichkeit, nach bestimmten Kriterien zu filtern.
        Details:
            Filtermöglichkeiten, z. B. nach Kunde, Datum oder Status der Bestellung (z. B. in Bearbeitung, abgeschlossen).
            Ausgabe in einer strukturierten Ansicht, ggf. tabellarisch mit den wichtigsten Bestellinformationen.
            Möglichkeit, den Status der Bestellung oder das zugehörige Kundenprofil anzuzeigen.

    Bestellungen bearbeiten
        Funktion: Ermöglicht die Bearbeitung bestehender Bestellungen.
        Details:
            Bearbeitbare Felder umfassen u. a. Produktmenge, Lieferdatum und Status der Bestellung.
            Validierung: Überprüfung der eingegebenen Änderungen auf Korrektheit.
            Speicherung: Speichert die aktualisierten Bestelldaten in der Datenbank oder externen Datei.

    Datenpersistenz
        Funktion: Sichert alle Daten zu Kunden und Bestellungen dauerhaft, sodass sie auch nach Schließen der Anwendung erhalten bleiben.
        Details:
            Speichert die Daten in einer Datenbank oder in externen Dateien (z. B. JSON, CSV, SQLite).
            Beim Start der Anwendung werden die gespeicherten Daten geladen.
            Regelmäßige automatische Sicherung bei Änderungen der Daten, um Datenverlust zu vermeiden.

Technische Anforderungen

    Programmiersprache: (z. B. Python, Java, C#)
    Speicheroptionen: Verwendung einer SQLite-Datenbank oder JSON-Dateien für Datenpersistenz.
    Benutzeroberfläche: Optionale grafische Benutzeroberfläche (GUI) oder eine einfache Konsolenanwendung.
    Fehlermanagement: Umgang mit Fehlern, wie z. B. unvollständigen Eingaben, ungültigen Kundennummern oder fehlgeschlagener Verbindung zur Datenbank.

Benutzerrollen und Berechtigungen

    Admin: Kann alle Funktionen nutzen, inklusive dem Bearbeiten und Löschen von Bestellungen.
    Mitarbeiter: Kann nur Kunden- und Bestellinformationen anzeigen und neue Kunden sowie Bestellungen hinzufügen.

Ausblick und Erweiterungen

    Erweiterte Suche: Hinzufügen einer detaillierten Such- und Filterfunktion für Kunden und Bestellungen.
    Export- und Importfunktion: Exportieren und Importieren von Kundendaten und Bestellungen als CSV/Excel.
    Benachrichtigungssystem: Hinzufügen von Benachrichtigungen für Kunden über den Status ihrer Bestellungen.
    Berichterstellung: Erstellung von Berichten für Umsatz, Anzahl Bestellungen und Kundenaktivität.

Diese Dokumentation soll als Ausgangspunkt für die Entwicklung des Kunden- und Bestellmanagementsystems dienen und die grundlegenden Anforderungen und Funktionen festlegen.
