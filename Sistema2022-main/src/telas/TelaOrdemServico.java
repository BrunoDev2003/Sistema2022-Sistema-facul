package telas;

import componentes.MeuCampoTexto;
import dao.Ordem_ServicoDao;
import pojo.Ordem_Servico;

public class TelaOrdemServico extends TelaCadastro {
    private Ordem_Servico ordem_servico = new Ordem_Servico();
    private Ordem_ServicoDao ordem_ServicoDao = new Ordem_ServicoDao();
    private MeuCampoTexto mctServico = new MeuCampoTexto("Serviço", 30, true);
    private MeuCampoTexto mctEstEqui = new MeuCampoTexto( "Estado do EstEqui",  30,  true);
    private MeuCampoTexto mctCodigo = new MeuCampoTexto("Código", 5, false) {
        @Override
        public void setEnabled(boolean status) {
            super.setEnabled(false);
        }
    };

    public TelaOrdemServico() {
        super("Ordem Serviço");
        setVisible(true);
        adicionaCampo(mctCodigo, 1, 1, 1, 1);
        adicionaCampo(mctServico, 1, 2, 1, 1);
        adicionaCampo(mctEstEqui, 2, 2, 1, 1);

//       mostraLinhasColunasComponentes();
        habilitaCampos(false);
        pack();
        setVisible(true);
    } 
    
    public void setaPojo() {
        ordem_servico.setIdOrdemServico(Integer.parseInt("0" + mctCodigo.getValor()));
        ordem_servico.setServico(mctServico.getValor());
        ordem_servico.setEstadoEquipamento(mctEstEqui.getValor());
    }

    @Override
    public boolean incluir() {
        setaPojo();
        boolean resultado = ordem_ServicoDao.incluir(ordem_servico);
        if (resultado == true) {
            mctCodigo.setText("" + ordem_servico.getIdOrdemServico());
        }
        return resultado;
    }

    @Override
    public boolean alterar() {
        setaPojo();
        return ordem_ServicoDao.alterar(ordem_servico);
    }

    @Override
    public boolean excluir() {
        setaPojo();
        return ordem_ServicoDao.excluir(ordem_servico);
    }

    @Override
    public boolean consultar() {
        new TelaConsulta(this,
                "Consulta de Ordem Servico",
                new String[]{"Código", "Servico", "Estado Equipamento"},
                Ordem_ServicoDao.SQL_PESQUISAR);
        return true;
    }

    @Override
    public void preencherDados(int id) {
        ordem_servico.setIdOrdemServico(id);
        ordem_ServicoDao.consultar(ordem_servico);
        mctCodigo.setValor("" + ordem_servico.getIdOrdemServico());
        mctServico.setValor(ordem_servico.getServico());
        mctEstEqui.setValor(ordem_servico.getEstadoEquipamento());
       // mcsnAtivo.setValor(cidade.getAtivoCidade() == 'S' ? "Sim" : "Não");

        super.preencherDados(id);
    }
}
