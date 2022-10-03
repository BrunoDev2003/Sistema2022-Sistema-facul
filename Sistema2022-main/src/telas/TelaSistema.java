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
    private JDesktopPane jdp = new JDesktopPane();
    private JMenuBar jmb = new JMenuBar();
    private JMenu jmCadastro = new JMenu("Cadastro");
    private JMenu jmOrcamento = new JMenu("Orçamento");
    private JMenu jmOrdemServico = new JMenu("Ordem Serviço");
    private JMenuItem jmiCadastroDoCliente = new JMenuItem("Cadastro do cliente");
    private JMenuItem jmiOrcamento = new JMenuItem("Cadastro do cliente");

    public TelaSistema(String titulo) {
        setTitle(titulo);
        getContentPane().add(jdp);
        jdp.setBackground(Color.blue);
        setJMenuBar(jmb);
        jmb.add(jmCadastro);
        jmb.add(jmOrcamento);
        jmb.add(jmOrdemServico);
        adicionarItemMenu(jmCadastro, jmiCadastroDoCliente);
        adicionarItemMenu(jmOrcamento, jmiOrcamento);
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
            TelaCadastroPais telaCadastroPais = 
                    new TelaCadastroPais();
            jdp.add(telaCadastroPais);
        }
        if (ae.getSource() == jmiCadastroDoCliente) {
            TelaCadastroPais telaCadastroPais = 
                    new TelaCadastroPais();
            jdp.add(telaCadastroPais);
        }
    }
}
