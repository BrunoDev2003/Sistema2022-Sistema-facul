package pojo;

public class Cliente {
    private int idCliente;
    private String Nome;
    private int Cpf_Cnpj;
    private int Fone;
    private String Endereco;


    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public String getNome() {
        return Nome;
    }
    public void setNome(String nome) {
        this.Nome = nome;
    }
    public int getCpf_Cnpj() {
        return Cpf_Cnpj;
    }
    public void setCpf_Cnpj(int cpf_Cnpj) {
        this.Cpf_Cnpj = cpf_Cnpj;
    }
    public int getFone() {
        return Fone;
    }
    public void setFone(int fone) {
        this.Fone = fone;
    }
    public String getEndereco() {
        return Endereco;
    }
    public void setEndereco(String endereco) {
        this.Endereco = endereco;
    }

    
}
