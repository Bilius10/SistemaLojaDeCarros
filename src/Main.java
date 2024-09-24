import DAO.PessoaDAO;
import Entidades.Pessoa;

import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("CPF: ");
        String cpf = teclado.next();

        Date data = new Date();

        System.out.print("EMAIL: ");
        String email = teclado.next();

        System.out.print("ID: ");
        int id = teclado.nextInt();

        System.out.print("Nome: ");
        String nome = teclado.next();

        System.out.print("Telefone: ");
        String telefone = teclado.next();

        Pessoa pessoa = new Pessoa(cpf, data, email, id, nome, telefone);
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.createPessoa(pessoa);
    }
}