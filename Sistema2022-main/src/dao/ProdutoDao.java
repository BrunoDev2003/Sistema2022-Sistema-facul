package dao;


import bd.Conexao;
import pojo.Produto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ProdutoDao {
    public final String SQL_INCLUIR = "INSERT INTO PRODUTO VALUES (?,?)";
    public final String SQL_ALTERAR = "UPDATE PRODUTO SET CADASTRO = ?, WHERE ID_PRODUTO";
    public final String SQL_EXCLUIR = "DELETE FROM PRODUTO WHERE ID_PRODUTO = ?";
    public final String SQL_CONSULTAR = "SELECT * FROM PRODUTO WHERE ID_PRODUTO = ?";

    public boolean incluir(Produto produto) {
        try {
            produto.setIdProduto(Conexao.getGenerator("G_PRODUTO"));
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_INCLUIR);
            ps.setInt(1, produto.getIdProduto());
            ps.setString(2, produto.getCadastro());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível incluir o Produto!");
            return false;
        }
    }

    public boolean excluir(Produto produto) {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_EXCLUIR);
            ps.setInt(1, produto.getIdProduto());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o Produto.");
            return false;
        }
    }

    public boolean alterar(Produto produto) {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_ALTERAR);
            ps.setInt(1, produto.getIdProduto());
            ps.setString(2, produto.getCadastro());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o Produto!.");
            return false;
        }
    }

    public boolean consultar(Produto produto) {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_CONSULTAR);
            ps.setInt(1, produto.getIdProduto());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                produto.setIdProduto(rs.getInt("NOME"));
                produto.setCadastro(rs.getString("NOME_Cadastro"));
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível consultar o Produto!.");
            return false;
        }
    }
}
