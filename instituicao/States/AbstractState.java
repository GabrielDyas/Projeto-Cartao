package instituicao.States;
import Objetos.State;
import instituicao.Instituicao;

public abstract class AbstractState implements State {
    protected Instituicao context;

    public AbstractState(Instituicao instituicao) {
        this.context = instituicao;
    }

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
