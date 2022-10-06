package telas;

import componentes.MeuCampoTexto;

public class TelaOrdemServico extends TelaCadastro {
    private MeuCampoTexto mctServico = new MeuCampoTexto("Serviço", 20, true);
    private MeuCampoTexto mctProduto = new MeuCampoTexto("Produto", 20, true);
    private MeuCampoTexto mctManutencao = new MeuCampoTexto( "manutenção",  30,  true);

    public TelaOrdemServico() {
        super("Ordem Serviço");
        setVisible(true);
        adicionaCampo(mctServico, 1, 2, 1, 1);
        adicionaCampo(mctProduto, 2, 2, 1, 3);
        adicionaCampo(mctManutencao, 1, 4, 1, 1);

//       mostraLinhasColunasComponentes();
        habilitaCampos(false);
        pack();
        setVisible(true);
    }  
}
