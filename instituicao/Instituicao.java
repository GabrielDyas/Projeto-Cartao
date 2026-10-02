package instituicao;
import cliente.Cliente;
import instituicao.States.*;
import Objetos.*;

public class Instituicao {
    public State currentState;
    public Produto AnaliseCompra;
    public Cliente cliente;

    public Instituicao(String nome, Cliente cliente) {

        this.currentState = new Ocioso(this); 
        this.cliente = cliente;
    }

    public void setState(State newState) {
        if (currentState != null) {
            currentState.leave();
        }
        this.currentState = newState;
        if (currentState != null) {
            currentState.enter(); 
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
