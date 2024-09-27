package DAO;

import Entidades.Cliente;
import Util.ConnectionMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public Entidades.Cliente createCliente(Cliente cliente){
        try {

            Connection coon = ConnectionMysql.openConnection();

            // Inserindo pessoa
            String sqlPessoa = "INSERT INTO pessoa (cpf, nome, data_nascimento, email, telefone) " +
                    "VALUES (?,?,?,?,?)";
            PreparedStatement statementPessoa = coon.prepareStatement(sqlPessoa);
            statementPessoa.setString(1, cliente.getCpf());
            statementPessoa.setString(2, cliente.getNome());
            statementPessoa.setDate(3, new java.sql.Date(cliente.getData_nascimento().getTime()));  // Formato correto para data
            statementPessoa.setString(4, cliente.getEmail());
            statementPessoa.setString(5, cliente.getTelefone());
            statementPessoa.executeUpdate();

            // Buscando o id da pessoa gerado
            String sqlPessoaFind = "SELECT id_pessoa FROM pessoa WHERE cpf=? LIMIT 1";
            PreparedStatement statementPessoaFind = coon.prepareStatement(sqlPessoaFind);
            statementPessoaFind.setString(1, cliente.getCpf());
            ResultSet resultSet = statementPessoaFind.executeQuery();

            int idPessoa = -1;
            while (resultSet.next()) {
                idPessoa = resultSet.getInt("id_pessoa");
            }

            // Inserindo o cliente
            String sqlCliente = "INSERT INTO cliente (pessoa_idpessoa) " +
                    "VALUES (?)";
            PreparedStatement statementCliente = coon.prepareStatement(sqlCliente);
            statementCliente.setInt(1, idPessoa);  // Usa o ID da pessoa obtido
            statementCliente.executeUpdate();  // Corrigido para executar a inserção do cliente

            ConnectionMysql.closeConnection();

            System.out.println("Cliente criado");

        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }

        return cliente;
    }

    public List<Cliente> findAll(){

        List<Cliente> objects = new ArrayList<>();
        try {
            Connection conn = ConnectionMysql.openConnection();

            String sql = "SELECT * FROM pessoa join cliente on pessoa.id_pessoa = cliente.pessoa_idpessoa";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Cliente cliente = new Cliente();
                cliente.setIdPessoa(resultSet.getInt("id_pessoa"));
                cliente.setCpf(resultSet.getString("cpf"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setData_nascimento(resultSet.getDate("data_nascimento"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setTelefone(resultSet.getString("telefone"));
                cliente.setIdCliente(resultSet.getInt("id_cliente"));
                objects.add(cliente);
            }


        }catch (SQLException e){
            System.out.println("Erro no findAll: "+e.getMessage());
        }
        return objects;
    }
}
