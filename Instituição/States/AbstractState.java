package instituição.States;
import Objetos.State;
import instituição.Instituicao;

public abstract class AbstractState implements State {
    protected Instituicao context;

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
