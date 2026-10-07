package instituicao.States;
import Objetos.AbstractState;
import instituicao.Instituicao;

public class Ocioso extends AbstractState<Instituicao> {
    
    public Ocioso(Instituicao context) {
        super(context); 
    }

    @Override 
    public void enter(Instituicao context) {
        
        if (context.analisandoCompra) {
            context.setState(new Respondendo(context));
        } 
        else if (context.cliente.cartao.compra != null) {
            context.setState(new Analisando(context));
        }
    }

    @Override
    public void execute(Instituicao context) {    
        System.out.println("Instituição está ociosa.");   
    }

    @Override 
    public void leave(Instituicao context) {
        System.out.println("Solicitação recebida, iniciando análise.");
    }
}