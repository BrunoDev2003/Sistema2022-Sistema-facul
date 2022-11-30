package telas;

import componentes.MeuCampoTexto;

public class TelaOrdemServico extends TelaCadastro {
    private MeuCampoTexto mctServico = new MeuCampoTexto("Serviço", 30, true);
    private MeuCampoTexto mctEstEqui = new MeuCampoTexto( "Estado do EstEqui",  30,  true);

    public TelaOrdemServico() {
        super("Ordem Serviço");
        setVisible(true);
        adicionaCampo(mctServico, 1, 2, 1, 1);
        adicionaCampo(mctEstEqui, 2, 2, 1, 1);

//       mostraLinhasColunasComponentes();
        habilitaCampos(false);
        pack();
        setVisible(true);
    }  
}
