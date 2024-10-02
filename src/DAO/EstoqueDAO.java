package DAO;

import Entidades.Estoque;
import Util.ConnectionMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Estoque> findAll(){

        List<Estoque> objects = new ArrayList<>();
        try {
            Connection conn = ConnectionMysql.openConnection();

            String sql = "SELECT * FROM estoque";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Estoque estoque = new Estoque();
                estoque.setIdEstoque(resultSet.getInt("id_estoque"));
                estoque.setMarca(resultSet.getString("marca"));
                estoque.setModelo(resultSet.getString("modelo"));
                estoque.setAno(resultSet.getDate("ano_fabricacao"));
                estoque.setCor(resultSet.getString("cor"));
                objects.add(estoque);
            }


        }catch (SQLException e){
            System.out.println("Erro no findAll: "+e.getMessage());
        }
        return objects;
    }

    public Estoque findById(int id){
        Estoque estoque = new Estoque();
        try {

            Connection coon = ConnectionMysql.openConnection();

            String sqlFindByID = "SELECT * FROM estoque WHERE id_estoque = ?";

            PreparedStatement statementFindById = coon.prepareStatement(sqlFindByID);
            statementFindById.setInt(1, id);
            ResultSet resultSet = statementFindById.executeQuery();

            while (resultSet.next()){

                estoque.setIdEstoque(resultSet.getInt("id_estoque"));
                estoque.setMarca(resultSet.getString("marca"));
                estoque.setModelo(resultSet.getString("modelo"));
                estoque.setAno(resultSet.getDate("ano_fabricacao"));
                estoque.setCor(resultSet.getString("cor"));
            }

        }catch (SQLException e){
            System.out.println("Erro ao buscar "+e.getMessage());
        }

        return estoque;
    }


}

