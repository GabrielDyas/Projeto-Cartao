package instituicao;
import cliente.Cliente;
import Objetos.*;
import instituicao.States.*;

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

    public Produto getAnaliseCompra(){
        return AnaliseCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

}
