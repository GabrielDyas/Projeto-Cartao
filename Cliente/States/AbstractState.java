package Cliente.States;
import Objetos.State;

public abstract class AbstractState implements State {
    @Override
    public void enter() {
        // Implementação padrão opcional

    }

    @Override
    public void execute() {
        // Implementação padrão opcional
    }

    @Override
    public void leave() {
        // Implementação padrão opcional
    }
}