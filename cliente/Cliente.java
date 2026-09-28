package cliente;

import java.util.concurrent.ThreadLocalRandom;

import Objetos.Cartao;
import Objetos.Produto;
import Objetos.State;
import cliente.states.Comprando;
import cliente.states.Passeando;

public class Cliente {
    private State currentState;
    public Cartao cartao;

    public Cliente() {
        cartao = new Cartao(new Objetos.Limites());
        setState(new Passeando(this));
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setState(State newState) {
        if (newState == null) {
            throw new IllegalArgumentException("O estado do cliente não pode ser nulo.");
        }

        if (currentState != null) {
            currentState.leave();
        }

        currentState = newState;
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
            estadoComprando.execute();
            Produto produtoComprado = estadoComprando.getProduto();
            atualizarEstado();
            return produtoComprado;
        }

        throw new IllegalStateException("O estado atual do cliente não é reconhecido.");
    }

    public void atualizarEstado() {
        if (ThreadLocalRandom.current().nextBoolean()) {
            setState(new Comprando(this));
        } else {
            setState(new Passeando(this));
        }
    }
}
