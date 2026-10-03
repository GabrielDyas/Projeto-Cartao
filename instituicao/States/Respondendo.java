package instituicao.States;
import Objetos.AbstractState;
import instituicao.Instituicao;

public class Respondendo extends AbstractState<Instituicao> {
    
    public Respondendo(Instituicao context) {
        super(context);
    }

    @Override 
    public void enter(Instituicao context) {
        System.out.println("Analise de compra finalizada.");
    }

    @Override
    public void execute(Instituicao context) {

        if (context.getAnaliseCompra().situacao) {
            System.out.printf( "Compra de(a) %s no valor de R$%.2f aprovada." , context.getAnaliseCompra().nome, context.getAnaliseCompra().valor );

        } else {
            System.out.printf( "Compra de(a) %s no valor de R$%.2f negada." , context.getAnaliseCompra().nome, context.getAnaliseCompra().valor );
        }

        if(context.getCliente().cartao.compra != null) {
            context.setState(new Analisando(context));
            context.execute(); // Executa a análise da próxima compra
        } else {
            context.setState(new Ocioso(context));
            context.execute();
        }

    }

    @Override 
    public void leave(Instituicao context) {
        System.out.println("Conferindo...");
        context.analisandoCompra = false; // Indica que a análise não está mais em andamento
    }
}
