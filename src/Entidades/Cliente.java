package Entidades;

import java.util.Date;

public class Cliente extends Pessoa{

    private  int idCliente;

    public Cliente(String cpf, Date data_nascimento, String email, int idPessoa, String nome, String telefone, int idCliente) {
        super(cpf, data_nascimento, email, idPessoa, nome, telefone);
        this.idCliente = idCliente;
    }

    public Cliente() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return super.toString();

    }
}
