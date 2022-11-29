package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conexao {
    private static Connection conexao = null;

    public static Connection getConexao() {
        if (conexao != null) {
            return conexao;
        } else {
            try {
                Class.forName("org.firebirdsql.jdbc.FBDriver");
                conexao = DriverManager.getConnection(
                        "jdbc:firebirdsql://localhost:3050/C:/Users/wwwbr/OneDrive/Documentos/Sistema2022-MAIN.FDB",
                        "SYSDBA", "bartallen");
                    return conexao;
            } catch (ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro no driver jdbc ");
            } catch (SQLException se) {
                se.printStackTrace();
                JOptionPane.showMessageDialog(null,"Erro no sql ");
            }
        }
        return conexao;
        
    }

    public static void main (String args[]) {
        try {
            String sql = "SELECT NOME_CLIENTE FROM CLIENTE";
            Statement st = Conexao.getConexao().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Erro ao consultar cliente ");
        }
        
    }
}
