package orm;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {

    public void criar(Veiculo veiculo) {
        String sql = "INSERT INTO veiculos(placa, modelo, ano) VALUES(?,?,?)";
        try (Connection conn = ConexaoDB.getConexao(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, veiculo.getPlaca());
            pstmt.setString(2, veiculo.getModelo());
            pstmt.setInt(3, veiculo.getAno());
            pstmt.executeUpdate();
            System.out.println("[ORM] Veículo inserido com sucesso: " + veiculo.getModelo());
        } catch (SQLException e) {
            System.out.println("[ORM] Erro ao inserir veículo: " + e.getMessage());
        }
    }

    public List<Veiculo> listarTodos() {
        String sql = "SELECT * FROM veiculos";
        List<Veiculo> lista = new ArrayList<>();
        try (Connection conn = ConexaoDB.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Veiculo v = new Veiculo(
                    rs.getInt("id"),
                    rs.getString("placa"),
                    rs.getString("modelo"),
                    rs.getInt("ano")
                );
                lista.add(v);
            }
        } catch (SQLException e) {
            System.out.println("[ORM] Erro ao listar veículos: " + e.getMessage());
        }
        return lista;
    }

    public void atualizar(Veiculo veiculo) {
        String sql = "UPDATE veiculos SET placa = ?, modelo = ?, ano = ? WHERE id = ?";
        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, veiculo.getPlaca());
            pstmt.setString(2, veiculo.getModelo());
            pstmt.setInt(3, veiculo.getAno());
            pstmt.setInt(4, veiculo.getId());
            pstmt.executeUpdate();
            System.out.println("[ORM] Veículo atualizado com sucesso (ID " + veiculo.getId() + ")");
        } catch (SQLException e) {
            System.out.println("[ORM] Erro ao atualizar veículo: " + e.getMessage());
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM veiculos WHERE id = ?";
        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("[ORM] Veículo deletado com sucesso (ID " + id + ")");
        } catch (SQLException e) {
            System.out.println("[ORM] Erro ao deletar veículo: " + e.getMessage());
        }
    }
}