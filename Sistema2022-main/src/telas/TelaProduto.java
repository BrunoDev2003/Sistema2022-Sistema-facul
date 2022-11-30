package telas;

import componentes.MeuCampoTexto;

public class TelaProduto extends TelaCadastro {
    private MeuCampoTexto mctProduto = new MeuCampoTexto("Cadastro do Produto", 30, true);

    
    public TelaProduto() {
        super("Produto");
        
        setVisible(true);
        adicionaCampo(mctProduto, 1, 1, 1, 1);

//      mostraLinhasColunasComponentes();
        habilitaCampos(false);
        pack();
        setVisible(true);
    }
    
}
