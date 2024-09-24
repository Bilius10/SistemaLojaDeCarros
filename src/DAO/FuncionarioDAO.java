package DAO;

import Entidades.Funcionario;
import Util.ConnectionMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncionarioDAO {

    public Funcionario createFuncionario(Funcionario funcionario){

        try {

            Connection coon = ConnectionMysql.openConnection();

            String sql = "INSERT INTO funcionario (cargo, salario, setor, status, pessoa_idpessoa)"+
                    "VALUES(?,?,?,?,?)";

            PreparedStatement statement = coon.prepareStatement(sql);
            statement.setString(1, funcionario.getCargo());
            statement.setDouble(2, funcionario.getSalario());
            statement.setString(3, funcionario.getSetor());
            statement.setInt(4, funcionario.getStatus());
            statement.setInt(5, funcionario.getPessoa_idpessoa().getIdPessoa());
            statement.executeUpdate();

            ConnectionMysql.closeConnection();
            System.out.println("Funcionario adicionado");

        }catch (SQLException e){
            System.out.println("Erro a salvar: "+e.getMessage());
        }

        return funcionario;
    }
}
