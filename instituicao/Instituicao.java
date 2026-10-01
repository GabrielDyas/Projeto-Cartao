package instituicao;
import cliente.Cliente;
import instituicao.States.*;
import Objetos.*;

public class Instituicao {
    public State currentState;
    public Produto AnaliseCompra;
    public Cliente cliente;

    public Instituicao(String nome, Cliente cliente) {

        this.currentState = new OciosoState(this); 
        this.cliente = cliente;
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
        this.currentState.execute();
    }

    public Produto getAnaliseCompra(){
        return AnaliseCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    

}
