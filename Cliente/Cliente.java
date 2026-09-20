package cliente;
import Objetos.Cartao;
import Objetos.State;
import cliente.States.Passeando;
public class Cliente {
    public State currentState;
    public Cartao cartao; 

    public Cliente() {
        this.cartao = new Cartao(new Objetos.Limites());
        this.setState(new  Passeando());
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
}
