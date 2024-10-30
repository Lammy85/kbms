package repos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Kunde;
public class KundeRepo {
    private Connection connection;
    public KundeRepo(String dbPath) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
            createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void createTable() {
        String query = """
                CREATE TABLE IF NOT EXISTS kunden (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    vorname VARCHAR(50),
                    nachname VARCHAR(50),
                    kundennummer INTEGER,
                    strasse VARCHAR(50),
                    hausnummer INTEGER,
                    plz INTEGER,
                    wohnort VARCHAR(50)
                );
                """;
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void kundeHinzufuegen(Kunde kunde) {
        String query = "INSERT INTO kunden (vorname, nachname, kundennummer, strasse, hausnummer, plz, wohnort) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, kunde.getVorname());
            pstmt.setString(2, kunde.getNachname());
            pstmt.setInt(3, kunde.getKundennummer());
            pstmt.setString(4, kunde.getStrasse());
            pstmt.setInt(5, kunde.getHausnummer());
            pstmt.setInt(6, kunde.getPlz());
            pstmt.setString(7, kunde.getWohnort());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Kunde> getKunde() {
        List<Kunde> kunden = new ArrayList<>();
        String query = "SELECT vorname, nachname, kundennummer, strasse, hausnummer, plz, wohnort FROM kunden";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Kunde kunde  = new Kunde(
                        rs.getString("vorname"),
                        rs.getString("nachname"),
                        rs.getInt("kundennummer"),
                        rs.getString("strasse"),
                        rs.getInt("hausnummer"),
                        rs.getInt("plz"),
                        rs.getString("wohnort")
                );
                kunden.add(kunde);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kunden;
    }
    public void kundeLoeschen(int kundennummer) {
        String query = "DELETE FROM kunden WHERE kundennummer = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, String.valueOf(kundennummer));
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