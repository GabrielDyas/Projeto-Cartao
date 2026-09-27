package cliente;

import Objetos.*;
import cliente.States.*;

public class Cliente {

    private State currentState;
    private Cartao cartao;

    public Cliente() {
        this.cartao = new Cartao(new Objetos.Limites());

        setState(new Passeando(this));
    }

    public void setState(State newState) {

        if (currentState != null) {
            currentState.leave();
        }

        currentState = newState;

        if (currentState != null) {
            currentState.enter();
        }
    }

    public void execute() {

        if (currentState != null) {
            currentState.execute();
        }
    }

    public Produto comprar(String tipo, double preco) {

        Comprando estadoComprando = new Comprando(this);

        setState(estadoComprando);

        Produto produto = estadoComprando.criarProduto(tipo, preco);

        estadoComprando.execute();

        return produto;
    }
}