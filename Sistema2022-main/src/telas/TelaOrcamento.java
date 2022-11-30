package telas;

import componentes.MeuCampoTexto;

public class TelaOrcamento extends TelaCadastro {
    private MeuCampoTexto mctEquipamento= new MeuCampoTexto("Equipamento", 30, true);
    private MeuCampoTexto mctMarca= new MeuCampoTexto("Marca", 30, true);
    private MeuCampoTexto mccServico = new MeuCampoTexto("Manutenção", 30, true);
    public TelaOrcamento() {
        super("Orçamento");
        setVisible(true);
        adicionaCampo(mctEquipamento, 1, 1, 1, 1);
        adicionaCampo(mctMarca, 2, 1, 1, 3);
        adicionaCampo(mccServico, 3, 1, 1, 1);
//       mostra as Linhas Colunas Componentes();
        habilitaCampos(false);
        pack();
        setVisible(true);
    }    
}
