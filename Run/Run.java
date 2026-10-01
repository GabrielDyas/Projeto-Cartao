package Run;
import cliente.Cliente;
import instituicao.Instituicao;
import instituicao.States.*;
import Objetos.*;

public class Run {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Instituicao instituicao = new Instituicao("Banco", cliente);
        cliente.instituicao = instituicao;
        int contador = 30;

        // Simulação de interações do cliente com a instituição
        while (true) {
            contador--;
            ControleDeTempo.passarUmDia();
            if (contador <= 0) {
                break;
            }

            System.out.println("------------------------------------------------");

            if (ControleDeTempo.getDia().getDayOfMonth() == 5){
                cliente.cartao.FechamentoFatura();
                System.out.println("______");
            }

            cliente.logCliente();
            if(cliente.vaiComprar()) {
                cliente.setState(new cliente.states.Comprando(cliente));
                cliente.execute();
            } 
            else {
                cliente.setState(new cliente.states.Passeando(cliente));
                cliente.execute();
            }
            System.out.println("______");
            
            if (instituicao.currentState instanceof instituicao.States.Analisando) {
                instituicao.setState(new Respondendo(instituicao));
                instituicao.execute();
            }
            if (cliente.cartao.compra != null) {
                // Simula a análise da compra pela instituição
                instituicao.setState(new Analisando(instituicao));
                instituicao.execute();
            } else {
                instituicao.setState(new OciosoState(instituicao));
                instituicao.execute();
            }
        }
    }
}