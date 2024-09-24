package DAO;

import Entidades.Pessoa;
import Util.ConnectionMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaDAO {

    public Pessoa createPessoa(Pessoa pessoa){

        try {
            Connection coon = ConnectionMysql.openConnection();

            String sql = "INSERT INTO pessoa (cpf, nome, data_nascimento, email, telefone)"+
                    "VALUES (?,?,?,?,?)";

            PreparedStatement statement = coon.prepareStatement(sql);
            statement.setString(1, pessoa.getCpf());
            statement.setString(2, pessoa.getNome());
            statement.setString(3, String.valueOf( new java.sql.Date(pessoa.getData_nascimento().getTime())));
            statement.setString(4, pessoa.getEmail());
            statement.setString(5, pessoa.getTelefone());
            statement.executeUpdate();

            ConnectionMysql.closeConnection();
            System.out.println("Pessoa adiciona");

        } catch (SQLException e) {
            System.out.println("Problema ao salvar "+e.getMessage());
        }

        return pessoa;
    }
}
