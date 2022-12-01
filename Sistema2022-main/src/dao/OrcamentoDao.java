package dao;


import pojo.Orcamento;
import bd.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class OrcamentoDao {
    public final String SQL_INCLUIR = "INSERT INTO ORCAMENTO VALUES (?,?,?)";
    public final String SQL_ALTERAR = "UPDATE ORCAMENTO SET EQUIPAMENTO = ?, MARCA = ?, MANUTENCAO = ? WHERE ID_ORCAMENTO = ?";
    public final String SQL_EXCLUIR = "DELETE FROM ORCAMENTO WHERE ID_ORCAMENTO = ?";
    public final String SQL_CONSULTAR = "SELECT * FROM ORCAMENTO WHERE ID_ORCAMENTO = ?";
    public static final String SQL_PESQUISAR = "SELECT ID_ORCAMENTO, EQUIPAMENTO, MARCA, MANUTENCAO, FROM ORCAMENTO JOIN EQUIPAMENTO ON ORCAMENTO.ID_ORCAMENTO = ORCAMENTO.ID_ORCAMENTO ORDER BY MARCA";


    public boolean incluir(Orcamento orcamento) {
        try {
            orcamento.setIdOrcamento(Conexao.getGenerator("G_ORCAMENTO"));
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_INCLUIR);
            ps.setInt(1, orcamento.getIdOrcamento());
            ps.setString(2, orcamento.getEquipamento());
            ps.setString(3, orcamento.getManutencao());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível incluir o Orçamento!.");
            return false;
        }
    }

    public boolean alterar(Orcamento orcamento) {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_ALTERAR);
            ps.setString(1, orcamento.getEquipamento());
            ps.setString(2, orcamento.getMarca());
            ps.setString(3, "" + orcamento.getManutencao());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o Orcamento!.");
            return false;
        }
    }

    public boolean excluir(Orcamento orcamento) {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_EXCLUIR);
            ps.setInt(1, orcamento.getIdOrcamento());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o Orcamento!.");
            return false;
        }
    }

    public boolean consultar(Orcamento orcamento) {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_CONSULTAR);
            ps.setInt(1, orcamento.getIdOrcamento());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                orcamento.setEquipamento(rs.getString("NOME"));
                orcamento.setMarca(rs.getString("NOME_MARCA"));
                orcamento.setManutencao(rs.getString("ID_ESTADO"));
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível consultar o Orcamento!.");
            return false;
        }
    }
}
