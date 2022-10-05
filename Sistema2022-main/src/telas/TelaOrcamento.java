package telas;

import componentes.MeuCampoTexto;

public class TelaOrcamento extends TelaCadastro {
    private MeuCampoTexto mctNome = new MeuCampoTexto("Nome", 5, true);
    private MeuCampoTexto mctCpfCNPJ = new MeuCampoTexto("CPF/CNPJ", 20, true);
    private MeuCampoTexto mctFone = new MeuCampoTexto( "Fone",  20,  true);
    private MeuCampoTexto mccEndereco = new MeuCampoTexto("Endereco", 20, true);
    public TelaOrcamento() {
        super("Orçamento");
        setVisible(true);
        adicionaCampo(mctNome, 1, 2, 1, 1);
        adicionaCampo(mctCpfCNPJ, 2, 2, 1, 3);
        adicionaCampo(mctFone, 1, 4, 1, 1);
        adicionaCampo(mccEndereco, 3, 1, 1, 1);
//       mostraLinhasColunasComponentes();
        habilitaCampos(false);
        pack();
        setVisible(true);
    }    
}
