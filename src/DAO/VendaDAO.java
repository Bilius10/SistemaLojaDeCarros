package DAO;

import Entidades.Venda;
import Util.ConnectionMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    public Venda createVenda(Venda venda){

       try {
            Connection coon = ConnectionMysql.openConnection();

            String sqlCliente = "SELECT id_cliente FROM cliente WHERE id_cliente = ?";
            PreparedStatement statementCliente = coon.prepareStatement(sqlCliente);
            statementCliente.setInt(1, venda.getIdCliente());
            ResultSet resultSetCliente = statementCliente.executeQuery();

            if(!resultSetCliente.next()){
                return null;
            }

            String sqlFuncionario = "SELECT id_funcionario FROM funcionario WHERE id_funcionario = ?";
            PreparedStatement statementFuncionario = coon.prepareStatement(sqlFuncionario);
            statementFuncionario.setInt(1, venda.getIdFuncionario());

            ResultSet resultSetFuncionario = statementCliente.executeQuery();

            if(!resultSetFuncionario.next()){
                return null;
            }


            String sql = "INSERT INTO venda (data_venda, total, status, id_funcionario, id_cliente, id_estoque)"+
                    "VALUES(?,?,?,?,?,?)";

            PreparedStatement statement = coon.prepareStatement(sql);
            statement.setString(1, String.valueOf(new java.sql.Date(venda.getDataVenda().getTime())));
            statement.setDouble(2, venda.getTotal());
            statement.setInt(3, venda.getStatus());
            statement.setInt(4, venda.getIdFuncionario());
            statement.setInt(5, venda.getIdCliente());
            statement.setInt(6, venda.getIdEstoque());
            ConnectionMysql.closeConnection();

        }catch (SQLException e){
            System.out.println("Erro ao salvar: "+e.getMessage());
        }

        return venda;
    }

    public List<Venda> findAll(){

        List<Venda> objects = new ArrayList<>();
        try {
            Connection conn = ConnectionMysql.openConnection();

            String sql = "SELECT * FROM venda";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Venda venda = new Venda();
                venda.setIdVenda(resultSet.getInt("id_venda"));
                venda.setDataVenda(resultSet.getDate("data_venda"));
                venda.setTotal(resultSet.getDouble("total"));
                venda.setStatus(resultSet.getInt("status"));
                venda.setIdFuncionario(resultSet.getInt("id_funcionario"));
                venda.setIdCliente(resultSet.getInt("id_cliente"));
                venda.setIdEstoque(resultSet.getInt("id_estoque"));

                objects.add(venda);
            }


        }catch (SQLException e){
            System.out.println("Erro no findAll: "+e.getMessage());
        }
        return objects;
    }

    public Venda findById(int id){
        Venda venda = new Venda();
        try {

            Connection coon = ConnectionMysql.openConnection();

            String sqlFindByID = "SELECT * FROM venda where id_venda = ? ";

            PreparedStatement statementFindById = coon.prepareStatement(sqlFindByID);
            statementFindById.setInt(1, id);
            ResultSet resultSet = statementFindById.executeQuery();

            while (resultSet.next()){

                venda.setIdVenda(resultSet.getInt("id_venda"));
                venda.setDataVenda(resultSet.getDate("data_venda"));
                venda.setTotal(resultSet.getDouble("total"));
                venda.setStatus(resultSet.getInt("status"));
                venda.setIdFuncionario(resultSet.getInt("id_funcionario"));
                venda.setIdCliente(resultSet.getInt("id_cliente"));
                venda.setIdEstoque(resultSet.getInt("id_estoque"));
            }

        }catch (SQLException e){
            System.out.println("Erro ao buscar "+e.getMessage());
        }

        return venda;
    }

    public void deleteFuncionario(int id){
        try {

            Connection conn = ConnectionMysql.openConnection();

            String sqlDelete = "Delete from venda where id_venda = ?";

            PreparedStatement statementDelete = conn.prepareStatement(sqlDelete);
            statementDelete.setInt(1, id);

            int rowsAffected = statementDelete.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Venda excluida");
            }

        }catch (SQLException e){
            System.out.println("Erro ao excluir Cliente: "+e.getMessage());
        }

    }
}

