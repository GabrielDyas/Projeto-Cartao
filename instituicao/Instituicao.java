package instituicao;
import cliente.Cliente;
import Objetos.*;

public class Instituicao {
    public State<Instituicao> currentState;
    public boolean analisandoCompra;
    public Produto AnaliseCompra;
    public Cliente cliente;

    public Instituicao(String nome, Cliente cliente) {

        this.currentState = null; 
        this.cliente = cliente;
    }

    public void setState(State<Instituicao> newState) {
        if (currentState != null && currentState != newState) {
            currentState.leave(this);
        }
  
            this.currentState = newState;
        
        if (currentState != null) {
            currentState.enter(this);
        }
    }

    public void execute() {
        this.currentState.execute(this);
    }

    public Produto getAnaliseCompra(){
        return AnaliseCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }
    

    

}
