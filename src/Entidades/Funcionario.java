package Entidades;

import java.util.Date;

public class Funcionario extends Pessoa {

    private int idFuncionario;
    private String cargo;
    private double salario;
    private String setor;
    private int status;

    public Funcionario(String cpf, Date data_nascimento, String email, int idPessoa, String nome, String telefone, String cargo, int idFuncionario, double salario, String setor) {
        super(cpf, data_nascimento, email, idPessoa, nome, telefone);
        this.cargo = cargo;
        this.idFuncionario = idFuncionario;
        this.salario = salario;
        this.setor = setor;
        this.status = 1;
    }

    public Funcionario() {
        this.status = 1;
    }

    public String getCargo() {

        return cargo;
    }

    public void setCargo(String cargo) {

        this.cargo = cargo;
    }

    public int getIdFuncionario() {

        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {

        this.idFuncionario = idFuncionario;
    }

    public double getSalario() {

        return salario;
    }

    public void setSalario(double salario) {

        this.salario = salario;
    }

    public String getSetor() {

        return setor;
    }

    public void setSetor(String setor) {

        this.setor = setor;
    }

    public int getStatus() {

        return status;
    }

    public void setStatus(int status) {

        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
