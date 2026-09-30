package Run;
import cliente.Cliente;
import instituicao.Instituicao;

public class Run {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Instituicao instituicao = new Instituicao("Banco", cliente);
        cliente.instituicao = instituicao;
        int contador = 10;

        // Simulação de interações do cliente com a instituição
        while (true) {
            contador--;
            if (contador <= 0) {
                break;
            }

            System.out.println("------------------------------------------------");
            cliente.logCliente();
            if(cliente.vaiComprar()) {
                cliente.setState(new cliente.states.Comprando(cliente));
                cliente.execute();
            } else {
                cliente.setState(new cliente.states.Passeando(cliente));
                cliente.execute();
            }
            System.out.println("______");
            if (cliente.currentState instanceof cliente.states.Comprando) {
                // Simula a análise da compra pela instituição
                instituicao.setState(new instituicao.States.Analisando());
                instituicao.execute();
            } else {
                instituicao.setState(new instituicao.States.OciosoState());
                instituicao.execute();
            }
        }
    }
}
