package Run;
import cliente.Cliente;
import instituicao.Instituicao;
import Objetos.*;

public class Run {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Instituicao instituicao = new Instituicao("Banco", cliente);
        cliente.instituicao = instituicao;
        int contador = 6;

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
  
            // Lógica de interação do cliente
            cliente.setState(new cliente.states.Passeando(cliente));
            cliente.execute();
            
            //Separador do cliente e da instituição
            System.out.println("--------------");

            // Lógica de interação com a instituição
            instituicao.setState(new instituicao.States.Ocioso(instituicao));
            instituicao.execute();


        }
    }
}