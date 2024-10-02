package DAO;

import Entidades.Venda;
import Util.ConnectionMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VendaDAO {

    public Venda createVenda(Venda venda){

        try {
            Connection coon = ConnectionMysql.openConnection();

            String sql = "INSERT INTO venda (data_venda, total, status, id_funcionario, id_cliente, id_estoque)"+
                    "VALUES(?,?,?,?,?,?)";

            PreparedStatement statement = coon.prepareStatement(sql);
            statement.setString(1, String.valueOf(new java.sql.Date(venda.getDataVenda().getTime())));
            statement.setDouble(2, venda.getTotal());
            statement.setInt(3, venda.getStatus());
            statement.setInt(4, venda.getFuncionario().getIdFuncionario());
            statement.setInt(5, venda.getCliente().getIdCliente());
            statement.setInt(6, venda.getEstoque().getIdEstoque());


        }catch (SQLException e){
            System.out.println("Erro ao salvar: "+e.getMessage());
        }

        return venda;
    }
}

