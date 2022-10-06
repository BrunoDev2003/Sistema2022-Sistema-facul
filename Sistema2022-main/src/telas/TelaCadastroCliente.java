package telas;


import componentes.MeuCampoTexto;

public class TelaCadastroCliente extends TelaCadastro {
    private MeuCampoTexto mctNome = new MeuCampoTexto("Nome", 15, true);
    private MeuCampoTexto mctCpfCNPJ = new MeuCampoTexto("CPF/CNPJ", 20, true);
    private MeuCampoTexto mctFone = new MeuCampoTexto( "Fone",  20,  true);
    private MeuCampoTexto mccEndereco = new MeuCampoTexto("Endereco", 20, true);

    public TelaCadastroCliente() {
        super("Cadastro do Cliente");
        adicionaCampo(mctNome, 1, 1, 1, 1);
        adicionaCampo(mctCpfCNPJ, 2, 1, 1, 3);
        adicionaCampo(mctFone, 1, 7, 1, 1);
        adicionaCampo(mccEndereco, 3, 1, 1, 1);
//       mostraLinhasColunasComponentes();
        habilitaCampos(false);
        pack();
        setVisible(true);
    }    
}