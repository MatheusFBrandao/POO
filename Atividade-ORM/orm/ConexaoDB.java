package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class ConexaoDB {
    private static final String URL = "jdbc:sqlite:oficina.db";

    public static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void inicializarBanco() {
        String sql = "CREATE TABLE IF NOT EXISTS veiculos (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "placa TEXT NOT NULL, " +
                     "modelo TEXT NOT NULL, " +
                     "ano INTEGER NOT NULL" +
                     ");";
        try (Connection conn = getConexao(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("[DB] Banco de dados inicializado com sucesso.");
        } catch (SQLException e) {
            System.out.println("[DB] Erro ao inicializar o banco: " + e.getMessage());
        }
    }
}