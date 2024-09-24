package Entidades;

import java.util.Date;

public class Venda {

    private int idVenda;
    private Date dataVenda;
    private double total;
    private int status;
    private Funcionario funcionario;
    private Cliente cliente;
    private Estoque estoque;

    public Venda(Cliente cliente, Date dataVenda, Estoque estoque, Funcionario funcionario, int idVenda, double total) {
        this.cliente = cliente;
        this.dataVenda = dataVenda;
        this.estoque = estoque;
        this.funcionario = funcionario;
        this.idVenda = idVenda;
        this.status = 1;
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
