package Entidades;

import java.util.Date;

public class Venda {

    private int idVenda;
    private Date dataVenda;
    private double total;
    private int status;
    private int idFuncionario;
    private int idCliente;
    private int idEstoque;

    public Venda(int idVenda, Date dataVenda, double total, int status, int idFuncionario, int idCliente, int idEstoque) {
        this.idVenda = idVenda;
        this.dataVenda = dataVenda;
        this.total = total;
        this.status = status;
        this.idFuncionario = idFuncionario;
        this.idCliente = idCliente;
        this.idEstoque = idEstoque;
    }

    public Venda() {
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "idVenda=" + idVenda +
                ", dataVenda=" + dataVenda +
                ", total=" + total +
                ", status=" + status +
                ", idFuncionario=" + idFuncionario +
                ", idCliente=" + idCliente +
                ", idEstoque=" + idEstoque +
                '}';
    }
}
