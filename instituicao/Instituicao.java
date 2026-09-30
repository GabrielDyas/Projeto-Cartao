package instituicao;
import cliente.Cliente;
import instituicao.States.*;
import Objetos.*;

public class Instituicao {
    private AbstractState state;
    public Produto AnaliseCompra;
    public Cliente cliente;

    public Instituicao(String nome, Cliente cliente) {

        this.state = new OciosoState(); 
        this.cliente = cliente;
    }

    public void setState(AbstractState state) {
        this.state.leave(); 
        this.state = state;
        this.state.enter(); 
    }

    public void execute() {
        this.state.execute();
    }

    public Produto getAnaliseCompra(){
        return AnaliseCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    

}
