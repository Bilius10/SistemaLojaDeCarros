package DAO;

import Entidades.Estoque;
import Util.ConnectionMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EstoqueDAO {

    public Estoque createEstoque(Estoque estoque){
        try {
            //abrindo conexão com o banco
            Connection conn = ConnectionMysql.openConnection();

            //querry a ser executada
            String sql = "INSERT INTO estoque (marca, modelo, ano_fabricacao, cor) "+
                    "VALUES (?,?,?,?)";

            //Startment - responsavel por executar a querry
            PreparedStatement statement =  conn.prepareStatement(sql);
            statement.setString(1, estoque.getMarca());
            statement.setString(2, estoque.getModelo());
            statement.setString(3, String.valueOf(new java.sql.Date(estoque.getAno().getTime())));
            statement.setString(4, estoque.getCor());
            statement.executeUpdate();

            ConnectionMysql.closeConnection();
            System.out.println("Estoque adiciona");

        } catch (SQLException e) {
            System.out.println("Problema ao salvar "+e.getMessage());
        }

        return estoque;
    }
}
