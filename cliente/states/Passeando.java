package cliente.states;

import cliente.Cliente;

public class Passeando extends AbstractState {

    public Passeando(Cliente cliente) {
        super(cliente);
    }

    @Override 
    public void enter() {
        System.out.println("Cliente está saindo para passear.");
    }

    @Override
    public void execute() {
        System.out.println("Cliente está passeando");
    }
    
    @Override
    public void leave() {
        System.out.println("Cliente não está mais passeando");
    }
}
