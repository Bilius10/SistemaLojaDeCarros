package Entidades;

import java.util.Date;

public class Estoque {

    private int idEstoque;
    private String marca;
    private String modelo;
    private Date ano;
    private String cor;

    public Estoque(Date ano, String cor, int idEstoque, String marca, String modelo) {
        this.ano = ano;
        this.cor = cor;
        this.idEstoque = idEstoque;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Estoque() {
    }

    public Date getAno() {

        return ano;
    }

    public void setAno(Date ano) {

        this.ano = ano;
    }

    public String getCor() {

        return cor;
    }

    public void setCor(String cor) {

        this.cor = cor;
    }

    public int getIdEstoque() {

        return idEstoque;
    }

    public void setIdEstoque(int idEstoque) {

        this.idEstoque = idEstoque;
    }

    public String getMarca() {

        return marca;
    }

    public void setMarca(String marca) {

        this.marca = marca;
    }

    public String getModelo() {

        return modelo;
    }

    public void setModelo(String modelo) {

        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "idEstoque=" + idEstoque +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", cor='" + cor + '\'' +
                '}';
    }
}
