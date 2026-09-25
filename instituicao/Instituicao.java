package instituicao;
import Objetos.Produto;
import instituicao.States.AbstractState;
import instituicao.States.OciosoState;

public class Instituicao {
    private AbstractState state;
    private Produto AnaliseCompra;

    public Instituicao(String nome) {

        this.state = new OciosoState(); // Estado inicial
    }

    public void setState(AbstractState state) {
        this.state.leave(); // Execut   a ações ao sair do estado atual
        this.state = state;
        this.state.enter(); // Executa ações ao entrar no novo estado
    }

    public void execute() {
        state.execute();
    }

    public void avance(){
        
    }

    public Produto getAnaliseCompra() {
        return AnaliseCompra;
    }
    
}
