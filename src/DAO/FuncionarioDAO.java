package DAO;

import Entidades.Funcionario;
import Util.ConnectionMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public Funcionario createFuncionario(Funcionario funcionario){

        try {

            Connection coon = ConnectionMysql.openConnection();

            // Inserindo pessoa
            String sqlPessoa = "INSERT INTO pessoa (cpf, nome, data_nascimento, email, telefone) " +
                    "VALUES (?,?,?,?,?)";
            PreparedStatement statementPessoa = coon.prepareStatement(sqlPessoa);
            statementPessoa.setString(1, funcionario.getCpf());
            statementPessoa.setString(2, funcionario.getNome());
            statementPessoa.setDate(3, new java.sql.Date(funcionario.getData_nascimento().getTime()));
            statementPessoa.setString(4, funcionario.getEmail());
            statementPessoa.setString(5, funcionario.getTelefone());
            statementPessoa.executeUpdate();

            // Buscando o id da pessoa gerado
            String sqlPessoaFind = "SELECT id_pessoa FROM pessoa WHERE cpf=? LIMIT 1";
            PreparedStatement statementPessoaFind = coon.prepareStatement(sqlPessoaFind);
            statementPessoaFind.setString(1, funcionario.getCpf());
            ResultSet resultSet = statementPessoaFind.executeQuery();

            int idPessoa = -1;
            while (resultSet.next()) {
                idPessoa = resultSet.getInt("id_pessoa");
            }

            //criando o funcionario
            String sqlFuncionario = "INSERT INTO funcionario (cargo, salario, setor, status, pessoa_idPessoa) " +
                    "VALUES (?,?,?,?,?)";
            PreparedStatement statementFuncionario = coon.prepareStatement(sqlFuncionario);
            statementFuncionario.setString(1, funcionario.getCargo());
            statementFuncionario.setDouble(2, funcionario.getSalario());
            statementFuncionario.setString(3, funcionario.getSetor());
            statementFuncionario.setInt(4, funcionario.getStatus());
            statementFuncionario.setInt(5, idPessoa);
            statementFuncionario.executeUpdate();

            System.out.println("Funcionario adicionado ");
            ConnectionMysql.closeConnection();

        }catch (SQLException e){
            System.out.println("Erro a salvar: "+e.getMessage());
        }

        return funcionario;
    }

    public List<Funcionario> findAll(){

        List<Funcionario> objects = new ArrayList<>();
        try {
            Connection conn = ConnectionMysql.openConnection();

            String sql = "SELECT * FROM funcionario";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Funcionario funcionario = new Funcionario();
                objects.add(funcionario);
            }


        }catch (SQLException e){
            System.out.println("Erro no findAll: "+e.getMessage());
        }
        return objects;
    }

    public Funcionario findById(int id){
        Funcionario funcionario = new Funcionario();
        try {

            Connection coon = ConnectionMysql.openConnection();

            String sqlFindByID = "select * from funcionario join pessoa on funcionario.pessoa_idpessoa = pessoa.id_pessoa"+
                    " where funcionario.id_funcionario = ?";

            PreparedStatement statementFindById = coon.prepareStatement(sqlFindByID);
            statementFindById.setInt(1, id);
            ResultSet resultSet = statementFindById.executeQuery();

            while (resultSet.next()){

                funcionario.setIdFuncionario(resultSet.getInt("id_funcionario"));
                funcionario.setCargo(resultSet.getString("cargo"));
                funcionario.setSalario(resultSet.getDouble("salario"));
                funcionario.setSetor(resultSet.getString("setor"));
                funcionario.setStatus(resultSet.getInt("status"));
                funcionario.setIdPessoa(resultSet.getInt("id_pessoa"));
                funcionario.setCpf(resultSet.getString("cpf"));
                funcionario.setNome(resultSet.getString("nome"));
                funcionario.setData_nascimento(resultSet.getDate("data_nascimento"));
                funcionario.setEmail(resultSet.getString("email"));
                funcionario.setTelefone(resultSet.getString("telefone"));
            }

        }catch (SQLException e){
            System.out.println("Erro ao buscar "+e.getMessage());
        }

        return funcionario;
    }
}

