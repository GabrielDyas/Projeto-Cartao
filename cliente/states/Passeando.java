package cliente.states;

import Objetos.AbstractState;
import Objetos.ControleDeTempo;
import cliente.Cliente;

public class Passeando extends AbstractState<Cliente> {

    public Passeando(Cliente cliente) {
        super(cliente);
    }

    @Override 
    public void enter(Cliente context) {
  
        System.out.println("--------------");
        if (context.cartao.FECHAMENTO_FATURA == ControleDeTempo.getDia().getDayOfMonth()) {
            
            System.out.println("Dia de fechamento da fatura.");
            context.cartao.FechamentoFatura();

            System.out.println("-------");

        } 
        context.logCliente();
        if (context.vaiComprar()) {
            System.out.println("Cliente está saindo para comprar.");
            context.setState(new Comprando(context));
        } 
        else {
            System.out.println("Cliente está saindo para passear.");
        }
    }

    @Override
    public void execute(Cliente context) {
        System.out.println("Cliente está passeando");
    }
    
    @Override
    public void leave(Cliente context) {
    }
}

