package Cliente.States;

import Cliente.Cliente;

public class Passeando extends AbstractState {

    public Passeando(Cliente context) {
        super(context);
    }

    @Override
    public void enter() {
        System.out.println(context.getNome() + " começou a passear.");
    }

    @Override
    public void execute() {
        System.out.println(context.getNome() + " está passeando.");
    }

    @Override
    public void leave() {
        System.out.println(context.getNome() + " saiu do estado Passeando.");
    }
}