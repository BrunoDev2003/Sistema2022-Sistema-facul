package telas;


import componentes.MeuCampoTexto;
import dao.ClienteDao;
import pojo.Cliente;

public class TelaCadastroCliente extends TelaCadastro {
    private Cliente cliente = new Cliente();
    private ClienteDao clienteDao = new ClienteDao();
    private MeuCampoTexto mctNome = new MeuCampoTexto("Nome", 20, true);
    private MeuCampoTexto mctCpfCNPJ = new MeuCampoTexto("CPF/CNPJ", 20, true);
    private MeuCampoTexto mctFone = new MeuCampoTexto( "Fone",  20,  true);
    private MeuCampoTexto mccEndereco = new MeuCampoTexto("Endereco", 20, true);
    private MeuCampoTexto mctCodigo = new MeuCampoTexto("Código", 5, false) {
    @Override
    public void setEnabled(boolean status) {
        super.setEnabled(false);
    }
};

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

    public void setaPojo() {
        cliente.setIdCliente(Integer.parseInt("0" + mctNome.getValor()));
        cliente.setNome(mctNome.getValor());
        cliente.setCpf_Cnpj(Integer.parseInt(mctCpfCNPJ.getValor()));
        cliente.setFone(mctFone.getValor().charAt(0));
        cliente.setEndereco(mccEndereco.getValor());
    }

    @Override
    public boolean incluir() {
        setaPojo();
        boolean resultado = clienteDao.incluir(cliente);
        if (resultado == true) {
            mctCodigo.setText("" + cliente.getIdCliente());
        }
        return resultado;
    }

    @Override
    public boolean alterar() {
        setaPojo();
        return clienteDao.alterar(cliente);
    }

    @Override
    public boolean excluir() {
        setaPojo();
        return clienteDao.excluir(cliente);
    }

    @Override
    public boolean consultar() {
        new TelaConsulta(this,
                "Consulta de Cliente",
                new String[]{"Código", "Nome","CPF/CNPJ", "FONE", "ENDERECO"},
                ClienteDao.SQL_PESQUISAR);
        return true;
    }

    @Override
    public void preencherDados(int id) {
        cliente.setIdCliente(id);
        clienteDao.consultar(cliente);
        mctCodigo.setValor("" + cliente.getIdCliente());
        mctNome.setValor(cliente.getNome());
        mccEndereco.setValor(cliente.getEndereco());
        mctCpfCNPJ.setValor(cliente.getCpf_Cnpj());
        mctFone.setValor(cliente.getFone());

    super.preencherDados(id);
    }
}

    