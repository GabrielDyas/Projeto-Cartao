package Run;
import cliente.Cliente;

public class Run {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        System.out.println(cliente.cartao.getLimite());
    }
}
