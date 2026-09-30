package cliente.states;
import Objetos.State;
import cliente.Cliente;

public abstract class AbstractState implements State {
    protected Cliente context;

    public AbstractState(Cliente cliente) {
        this.context = cliente;
    }

    @Override
    public void enter() {
        // Implementação padrão opcional
        System.out.println("Cliente entrou em um estado.");
    }

    @Override
    public void execute() {
        // Implementação padrão opcional
        System.out.println("Cliente executou em um estado.");
    }

    @Override
    public void leave() {
        // Implementação padrão opcional
        System.out.println("Cliente saiu de um estado.");
    }
}