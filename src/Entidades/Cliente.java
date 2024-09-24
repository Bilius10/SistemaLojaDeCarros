package Entidades;

public class Cliente {

    private  int idCliente;
    private Pessoa pessoa;

    public Cliente(int idCliente, Pessoa pessoa) {
        this.idCliente = idCliente;
        this.pessoa = pessoa;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
