package Cliente.States;

import Cliente.Cliente;

public abstract class AbstractState implements State {

    protected Cliente context;

    public AbstractState(Cliente context) {
        this.context = context;
    }

    @Override
    public void enter() {
        // comportamento padrão
    }

    @Override
    public void execute() {
        // comportamento padrão
    }

    @Override
    public void leave() {
        // comportamento padrão
    }
}