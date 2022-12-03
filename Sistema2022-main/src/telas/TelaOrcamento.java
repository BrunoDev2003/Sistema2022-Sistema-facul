package telas;

import componentes.MeuCampoTexto;
import dao.OrcamentoDao;
import pojo.Orcamento;

public class TelaOrcamento extends TelaCadastro {
    private Orcamento orcamento = new Orcamento();
    private OrcamentoDao orcamentoDao = new OrcamentoDao();
    private MeuCampoTexto mctEquipamento= new MeuCampoTexto("Equipamento", 30, true);
    private MeuCampoTexto mctMarca= new MeuCampoTexto("Marca", 30, true);
    private MeuCampoTexto mccManutencao = new MeuCampoTexto("Manutenção", 30, true);
    private MeuCampoTexto mctCodigo = new MeuCampoTexto("Código", 5, false) {
        @Override
        public void setEnabled(boolean status) {
            super.setEnabled(false);
        }
    };
    public TelaOrcamento() {
        super("Orçamento");
        setVisible(true);
        adicionaCampo(mctCodigo, 1, 1, 1, 1);
        adicionaCampo(mctEquipamento, 1, 1, 1, 1);
        adicionaCampo(mctMarca, 2, 1, 1, 3);
        adicionaCampo(mccManutencao, 3, 1, 1, 1);
//       mostra as Linhas Colunas Componentes();
        habilitaCampos(false);
        pack();
        setVisible(true);
    }    

    public void setaPojo() {
        orcamento.setIdOrcamento(Integer.parseInt("0" + mctCodigo.getValor()));
        orcamento.setEquipamento(mctEquipamento.getValor());
        orcamento.setMarca(mctMarca.getValor());
        orcamento.setManutencao(mccManutencao.getValor());
    }

    @Override
    public boolean incluir() {
        setaPojo();
        boolean resultado = orcamentoDao.incluir(orcamento);
        if (resultado == true) {
            mctCodigo.setText("" + orcamento.getIdOrcamento());
        }
        return resultado;
    }

    @Override
    public boolean alterar() {
        setaPojo();
        return orcamentoDao.alterar(orcamento);
    }

    @Override
    public boolean excluir() {
        setaPojo();
        return orcamentoDao.excluir(orcamento);
    }

    @Override
    public boolean consultar() {
        new TelaConsulta(this,
                "Consulta de Orcamento",
                new String[]{"Código", "Equipamento", "Marca", "Manutenção"},
                OrcamentoDao.SQL_PESQUISAR);
        return true;
    }

    @Override
    public void preencherDados(int id) {
        orcamento.setIdOrcamento(id);
        orcamentoDao.consultar(orcamento);
        mctCodigo.setValor("" + orcamento.getIdOrcamento());
        mctEquipamento.setValor(orcamento.getEquipamento());
        mctMarca.setValor(orcamento.getMarca());
        mccManutencao.setValor(orcamento.getManutencao());

        super.preencherDados(id);
    }
}

