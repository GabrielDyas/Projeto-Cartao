package cliente;
import Objetos.Cartao;
import Objetos.Produto;
import Objetos.State;
import cliente.states.*;

public class Cliente {
    public State currentState;
    public Cartao cartao; 

    public Cliente() {
        this.cartao = new Cartao(new Objetos.Limites());
        this.setState(new Passeando(this));
    }

    public void setState(State newState) {
        if (currentState != null) {
            currentState.leave(); // Executa a lógica de saída do estado atual
        }
        this.currentState = newState;
        if (currentState != null) {
            currentState.enter(); // Executa a lógica de entrada do novo estado
        }
    }

    public void execute() {
        if (currentState != null) {
            currentState.execute();
        }
    }

    public Produto comprar() {
        Comprando estadoComprando = new Comprando(this);
        setState(estadoComprando);
        Produto produto = Produto.criarProduto();
        estadoComprando.execute();
        return produto;
    }

}