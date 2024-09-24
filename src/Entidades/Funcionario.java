package Entidades;

public class Funcionario {

    private int idFuncionario;
    private Pessoa pessoa_idpessoa;
    private String cargo;
    private double salario;
    private String setor;
    private int status;

    public Funcionario(String cargo, int idFuncionario, Pessoa pessoa_idpessoa, double salario, String setor) {
        this.cargo = cargo;
        this.idFuncionario = idFuncionario;
        this.pessoa_idpessoa = pessoa_idpessoa;
        this.salario = salario;
        this.setor = setor;
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

    public Pessoa getPessoa_idpessoa() {
        return pessoa_idpessoa;
    }

    public void setPessoa_idpessoa(Pessoa pessoa_idpessoa) {
        this.pessoa_idpessoa = pessoa_idpessoa;
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
}
