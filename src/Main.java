import DAO.ClienteDAO;
import Entidades.Cliente;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();
        ClienteDAO clienteDAO = new ClienteDAO();
        clientes = clienteDAO.findAll();
        clientes.forEach(System.out::println);
    }
}
