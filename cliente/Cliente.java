package cliente;
import java.util.concurrent.ThreadLocalRandom;

import Objetos.Cartao;
import Objetos.Produto;
import Objetos.State;
import cliente.states.*;

public class Cliente {
    private State currentState;
    public Cartao cartao;

    public Cliente() {
        this.cartao = new Cartao(new Objetos.Limites());
        this.setState(new Passeando(this));
    }

    public void atualizarEstado() {
        boolean vaiComprar = ThreadLocalRandom.current().nextBoolean();
        if (vaiComprar) {
            setState(new Comprando(this));
        } else {
            setState(new Passeando(this));
        }
    }

    private void setState(State newState) {
        if (currentState != null) {
            currentState.leave();
        }
        this.currentState = newState;
        currentState.enter();
    }

    public Produto execute() {
        if (currentState instanceof Passeando) {
            currentState.execute();
            atualizarEstado();
            return null;
        }

        if (currentState instanceof Comprando) {
            Comprando estadoComprando = (Comprando) currentState;
            currentState.execute();
            Produto produto = estadoComprando.getProduto();
            atualizarEstado();
            return produto;
        }

        throw new IllegalStateException("O cliente está em um estado não reconhecido.");
    }

    public State getCurrentState() {
        return currentState;
    }
}