package telas;

import componentes.MeuCampoTexto;
import dao.ProdutoDao;
import pojo.Produto;

public class TelaProduto extends TelaCadastro {
    private Produto produto = new Produto();
    private ProdutoDao produtoDao = new ProdutoDao();
    private MeuCampoTexto mctProduto = new MeuCampoTexto("Produto do Produto", 30, true);
    private MeuCampoTexto mctCodigo = new MeuCampoTexto("Código", 5, false) {
        @Override
        public void setEnabled(boolean status) {
            super.setEnabled(false);
        }
    };
    
    public TelaProduto() {
        super("Produto");
        
        setVisible(true);
        adicionaCampo(mctProduto, 1, 1, 1, 1);

//      mostraLinhasColunasComponentes();
        habilitaCampos(false);
        pack();
        setVisible(true);
    }
    
    public void setaPojo() {
        produto.setIdProduto(Integer.parseInt("0" + mctCodigo.getValor()));
        produto.setCadastro(mctProduto.getValor());
       // produto.setAtivoCidade(mcsnAtivo.getValor().charAt(0));
    }

    @Override
    public boolean incluir() {
        setaPojo();
        boolean resultado = produtoDao.incluir(produto);
        if (resultado == true) {
            mctCodigo.setText("" + produto.getIdProduto());
        }
        return resultado;
    }

    @Override
    public boolean alterar() {
        setaPojo();
        return produtoDao.alterar(produto);
    }

    @Override
    public boolean excluir() {
        setaPojo();
        return produtoDao.excluir(produto);
    }

    @Override
    public boolean consultar() {
        new TelaConsulta(this,
                "Consulta de Produto",
                new String[]{"Código", "Produto", "Cadastro"},
                ProdutoDao.SQL_PESQUISAR);
        return true;
    }

    @Override
    public void preencherDados(int id) {
        produto.setIdProduto(id);
        produtoDao.consultar(produto);
        mctCodigo.setValor("" + produto.getIdProduto());
        mctProduto.setValor(produto.getCadastro());
       // mcsnAtivo.setValor(cidade.getAtivoCidade() == 'S' ? "Sim" : "Não");
    
        super.preencherDados(id);
    }
    

}

