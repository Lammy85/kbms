package repos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Bestellung;

public class BestellungRepo {

    private Connection connection;

    public BestellungRepo(String dbPath) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
            createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTable() {
        String query = """
                CREATE TABLE IF NOT EXISTS bestellungen (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    bestellnummer INTEGER,
                    produkt VARCHAR(100)
                    stueckzahl INTEGER,
                    betrag FLOAT,
                    bezahlt BOOLEAN,
                    lieferstatus INTEGER
                );
                """;
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void bestellungHinzufuegen(Bestellung bestellung) {
        String query = "INSERT INTO bestellungen (bestellnummer, produkt, stueckzahl, betrag, bezahlt, lieferstatus) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, bestellung.getBestellnummer());
            pstmt.setString(2, bestellung.getProdukt());
            pstmt.setInt(3, bestellung.getStueckzahl());
            pstmt.setFloat(4, (float) bestellung.getBetrag());
            pstmt.setBoolean(5, bestellung.isBezahlt());
            pstmt.setInt(6, bestellung.getLieferstatus());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Bestellung> getBestellungen() {
        List<Bestellung> bestellungen = new ArrayList<>();
        String query = "SELECT bestellnummer, produkt, stueckzahl, betrag, bezahlt, lieferstatus FROM bestellungen";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Bestellung bestellung = new Bestellung(
                        rs.getInt("bestellnummer"),
                        rs.getString("produkt"),
                        rs.getInt("stueckzahl"),
                        rs.getFloat("betrag")
                );
                bestellung.setLieferstatus(rs.getInt("lieferstatus"));
                bestellung.setBezahlt(rs.getBoolean("bezahlt"));
                bestellungen.add(bestellung);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bestellungen;
    }

    public void bestellungBezahlt(int bestellnummer) {
        String query = "UPDATE bestellungen SET bezahlt = 1 WHERE bestellnummer = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, String.valueOf(bestellnummer));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void bestellungLoeschen(int bestellnummer) {
        String query = "DELETE FROM bestellungen WHERE bestellnummer = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, String.valueOf(bestellnummer));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
