package Entidades;

import java.util.Date;

public class Pessoa {

    private int idPessoa;
    private String cpf;
    private String nome;
    private Date data_nascimento;
    private String email;
    private String telefone;

    public Pessoa(String cpf, Date data_nascimento, String email, int idPessoa, String nome, String telefone) {
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.email = email;
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
