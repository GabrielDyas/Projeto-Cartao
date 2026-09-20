package instituição;
import Objetos.Produto;
import instituição.States.AbstractState;
import instituição.States.OciosoState;

import java.util.List;

public class Instituicao {
    private String nome;
    private AbstractState state;
    private List<Produto> listaDeAprovacao;

    public Instituicao(String nome) {
        this.nome = nome;
        this.state = new OciosoState(); // Estado inicial
    }

    public String getNome() {
        return nome;
    }

    public void setState(AbstractState state) {
        this.state.leave(); // Execut   a ações ao sair do estado atual
        this.state = state;
        this.state.enter(); // Executa ações ao entrar no novo estado
    }

    public void execute() {
        state.execute();
    }
}
