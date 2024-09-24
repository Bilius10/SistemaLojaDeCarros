package DAO;

import Util.ConnectionMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

    public Entidades.Cliente createCliente(Entidades.Cliente cliente){
        try {

            Connection coon = ConnectionMysql.openConnection();

            String sql = "INSERT INTO cliente(pessoa_idpessoa)"+
                    "VALUES (?)";

            PreparedStatement statement = coon.prepareStatement(sql);
            statement.setInt(1, cliente.getPessoa().getIdPessoa());
            statement.executeUpdate();

            ConnectionMysql.closeConnection();
            System.out.println("Cliente adiciona");

        }catch (SQLException e){
            System.out.println("Erro ao salvar: "+e.getMessage());
        }

        return cliente;
    }
}
