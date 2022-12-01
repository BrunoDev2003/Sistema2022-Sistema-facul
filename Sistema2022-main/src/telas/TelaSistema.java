package telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaSistema extends JFrame implements ActionListener {
    static JDesktopPane jdp = new JDesktopPane();
    private JMenuBar jmb = new JMenuBar();
    private JMenu jmCadastro = new JMenu("Cadastro");
    private JMenu jmOrcamento = new JMenu("Orçamento");
    private JMenu jmOrdemServico = new JMenu("Ordem Serviço");
    private JMenu jmProduto = new JMenu("Produto");
    private JMenuItem jmiCadastroDoCliente = new JMenuItem("Cadastro do cliente");
    private JMenuItem jmiOrcamento = new JMenuItem("Menu Orçamento");
    private JMenuItem jmiOrdemServico = new JMenuItem("Menu Ordem Serviço");
    private JMenuItem jmiProduto = new JMenuItem("Tela Produto");


    public TelaSistema(String titulo) {
        setTitle(titulo);
        getContentPane().add(jdp);
        jdp.setBackground(Color.DARK_GRAY);
        setJMenuBar(jmb);
        jmb.add(jmCadastro);
        jmb.add(jmOrcamento);
        jmb.add(jmOrdemServico);
        jmb.add(jmProduto);
        adicionarItemMenu(jmCadastro, jmiCadastroDoCliente);
        adicionarItemMenu(jmOrcamento, jmiOrcamento);
        adicionarItemMenu(jmOrdemServico, jmiOrdemServico);
        adicionarItemMenu(jmProduto, jmiProduto);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
    }
    
    private void adicionarItemMenu(JMenu menu, JMenuItem itemMenu) {
        menu.add(itemMenu);
        itemMenu.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jmiCadastroDoCliente) {
            TelaCadastroCliente telaCadastroCliente = 
                    new TelaCadastroCliente();
            jdp.add(telaCadastroCliente);
        } else if (ae.getSource() == jmiOrcamento) {
            TelaOrcamento telaOrcamento = 
                    new TelaOrcamento();
            jdp.add(telaOrcamento);
        } else if (ae.getSource() == jmiOrdemServico) {
            TelaOrdemServico telaOrdemServico = 
                    new TelaOrdemServico();
            jdp.add(telaOrdemServico);
        } else if (ae.getSource() == jmiProduto) {
            TelaProduto telaProduto = 
                    new TelaProduto();
            jdp.add(telaProduto);
        }
    }
}