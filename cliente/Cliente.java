package cliente;
import Objetos.Cartao;
import Objetos.State;
import cliente.states.*;
import instituicao.Instituicao;
import java.util.Random;

public class Cliente {
    public State currentState;
    public Cartao cartao;
    public Instituicao instituicao;

    public Cliente() {
        this.cartao = new Cartao(new Objetos.Limites());
        setState(new Passeando(this));
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

    public boolean vaiComprar() {
        int chance = new Random().nextInt(100);
        return chance < 50; // 50% de chance de comprar
    }

    public void logCliente() {
        System.out.printf("Limite disponível: R$%.2f\n", cartao.getLimite());
    }
}