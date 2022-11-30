package dao;


import bd.Conexao;
import pojo.Ordem_Servico;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Ordem_ServicoDao {
    public final String SQL_INCLUIR = "INSERT INTO ORDEM_SERVICO VALUES (?,?,?,?)";
    public final String SQL_ALTERAR = "UPDATE ORDEM_SERVICO SET SERVICO = ?, ESTADO_EQUIPAMENTO = ? WHERE ID_ORDEM_SERVICO";
    public final String SQL_EXCLUIR = "DELETE FROM ORDEM_SERVICO WHERE ID_ORDEM_SERVICO = ?";
    public final String SQL_CONSULTAR = "SELECT * FROM ORDEM_SERVICO WHERE ID_ORDEM_SERVICO = ?";

    public boolean incluir(Ordem_Servico ordem_servico) {
        try {
            ordem_servico.setIdOrdemServico(Conexao.getGenerator("G_ORDEM_SERVICO"));
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_INCLUIR);
            ps.setInt(1, ordem_servico.getIdOrdemServico());
            ps.setString(2, ordem_servico.getServico());
            ps.setString(3, ordem_servico.getEstadoEquipamento());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível incluir a Ordem de serviço!");
            return false;
        }
    }

    public boolean excluir(Ordem_Servico ordem_servico) {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_EXCLUIR);
            ps.setInt(1, ordem_servico.getIdOrdemServico());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a Ordem de servico!.");
            return false;
        }
    }

    public boolean alterar(Ordem_Servico ordem_servico) {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_ALTERAR);
            ps.setString(1, ordem_servico.getServico());
            ps.setString(2, ordem_servico.getEstadoEquipamento());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível alterar a Ordem de servico!.");
            return false;
        }
    }

    public boolean consultar(Ordem_Servico ordem_servico) {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_CONSULTAR);
            ps.setInt(1, ordem_servico.getIdOrdemServico());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ordem_servico.setServico(rs.getString("NOME"));
                ordem_servico.setEstadoEquipamento(rs.getString("NOME_MARCA"));
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível consultar a Ordem de servico.");
            return false;
        }
    }
}
