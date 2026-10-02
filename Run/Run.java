package Run;
import cliente.Cliente;
import instituicao.Instituicao;
import instituicao.States.*;
import cliente.states.*;
import Objetos.*;

public class Run {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Instituicao instituicao = new Instituicao("Banco", cliente);
        cliente.instituicao = instituicao;
        int contador = 60;

        // Simulação de interações do cliente com a instituição
        while (true) {
            contador--;
            ControleDeTempo.passarUmDia();
            if (contador <= 0) {
                break;
            }
            // Exibe informações do dia atual
            System.out.println("___________________________________");
            System.out.println("Dia: " + ControleDeTempo.getDia());

            // Verifica se é dia de fechamento da fatura do cartão
            if (ControleDeTempo.getDia().getDayOfMonth() == 5){
                cliente.cartao.FechamentoFatura();
            }

            System.out.println("--------------");
            /* incluir para dentro do padrão state */
            // Lógica de interação do cliente
            cliente.logCliente();
            if(cliente.vaiComprar()) {
                cliente.setState(new cliente.states.Comprando(cliente));
                cliente.execute();
            } 
            else {
                if (cliente.currentState instanceof Passeando) {
                    cliente.execute();
                }
                else {
                    cliente.setState(new cliente.states.Passeando(cliente));
                    cliente.execute();
                }
                
            }

            System.out.println("--------------");

            /* incluir para dentro do padrão state */
            // Lógica de interação com a instituição
            if (instituicao.currentState instanceof Analisando) {
                instituicao.setState(new Respondendo(instituicao));
                instituicao.execute();
            }
            if (cliente.cartao.compra != null) {
                instituicao.setState(new Analisando(instituicao));
                instituicao.execute();
            } 
            else {
                if (!(instituicao.currentState instanceof Ocioso)) {
                    instituicao.setState(new Ocioso(instituicao));
                }
                instituicao.execute();
            }
        }
    }
}