package instituicao;
import cliente.Cliente;
import Objetos.*;
import instituicao.States.*;

public class Instituicao {
    private AbstractState state;
    public Produto AnaliseCompra;

    public Instituicao(String nome) {

        this.state = new OciosoState(); 
    }

    public void setState(AbstractState state) {
        this.state.leave(); 
        this.state = state;
        this.state.enter(); 
    }

    public void execute() {
        state.execute();
    }

    public void avance(){
        
    }

    public Cliente infoCliente(Cliente cliente){
        return cliente;
    }

    public Produto getAnaliseCompra(){
        return AnaliseCompra;
    }
    
}
