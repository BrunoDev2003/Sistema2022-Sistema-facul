package dao;

import pojo.Cliente;
import bd.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ClienteDao {
    public final String SQL_INCLUIR = "INSERT INTO CLIENTE VALUES (?,?,?,?,?)";
    public final String SQL_ALTERAR = "UPDATE CIDADE SET NOME = ?, CPF_CNPJ = ?, FONE= ? ENDERECO = ?";
    public final String SQL_EXCLUIR = "DELETE FROM CLIENTE WHERE ID_CLIENTE = ?";
    public final String SQL_CONSULTAR = "SELECT * FROM CLIENTE WHERE ID_CLIENTE = ?";
    

    public boolean incluir(Cliente cliente) {
        try {
            cliente.setIdCliente(Conexao.getGenerator("G_CLIENTE"));
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_INCLUIR);
            ps.setInt(1, cliente.getIdCliente());
            ps.setString(2, cliente.getNome());
            ps.setInt(3, cliente.getCpf_Cnpj());
            ps.setString(4, "" + cliente.getFone());
            ps.setString(5, "" + cliente.getEndereco());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível incluir a Cidade.");
            return false;
        }
    }

    public boolean alterar(Cliente cliente) {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_ALTERAR);
            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getCpf_Cnpj());
            ps.setString(3, "" + cliente.getFone());
            ps.setString(4, cliente.getEndereco());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o Estado.");
            return false;
        }
    }

    public boolean excluir(Cliente cliente) {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_EXCLUIR);
            ps.setInt(1, cliente.getIdCliente());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a Cidade.");
            return false;
        }
    }

    public boolean consultar(Cliente cliente) {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_CONSULTAR);
            ps.setInt(1, cliente.getIdCliente());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente.setNome(rs.getString("NOME"));
                cliente.setCpf_Cnpj(rs.getInt("ID_ESTADO"));
                cliente.setFone(rs.getInt("ID_ESTADO"));
                cliente.setEndereco(rs.getString("ID_ESTADO"));
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível consultar o Cliente.");
            return false;
        }
    }
    
}