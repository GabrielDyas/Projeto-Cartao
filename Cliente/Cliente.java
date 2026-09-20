package Cliente;

import Cliente.States.Passeando;
import Cliente.States.Comprando;
import Objetos.Cartao;
import Objetos.Compra;

public class Cliente {

    private String nome;
    private State state;

    private Cartao cartao;
    private Compra compraAtual;

    public Cliente(String nome, Cartao cartao) {
        this.nome = nome;
        this.cartao = cartao;

        this.state = new Passeando(this);
        this.state.enter();
    }

    public String getNome() {
        return nome;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public Compra getCompraAtual() {
        return compraAtual;
    }

    public void comprar(String produto, double valor) {

        compraAtual = new Compra(produto, valor);

        setState(new Cliente.States.Comprando(this));

        execute();
    }

    public void passear() {
        setState(new Passeando(this));

        execute();
    }

    public void setState(State state) {

        if (this.state != null) {
            this.state.leave();
        }

        this.state = state;

        this.state.enter();
    }

    public void execute() {
        state.execute();
    }
}