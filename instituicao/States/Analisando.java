package instituicao.States;
import instituicao.Instituicao;
import Objetos.AbstractState;
public class Analisando extends AbstractState<Instituicao> {

    public Analisando(Instituicao context) {
        super(context); 
    }

    @Override 
    public void enter(Instituicao context) {
        System.out.printf("Iniciando análise de compra %s no valor de R$%.2f...\n", context.cliente.cartao.compra.nome, context.cliente.cartao.compra.valor);
        context.AnaliseCompra = context.cliente.cartao.compra; // Armazena a compra que está sendo analisada
        context.analisandoCompra = true; // Indica que a análise está em andamento
    }

    @Override
    public void execute(Instituicao context) {
        System.err.println("Analisando compra...");
        if(context.cliente.cartao.getLimite() < context.AnaliseCompra.valor) {
            // Lógica para quando o limite é insuficiente
            context.AnaliseCompra.situacao = false;
            context.cliente.cartao.Fatura.add(context.AnaliseCompra);
        } else {
            // Lógica para quando o limite é suficiente
            context.AnaliseCompra.situacao = true;
            context.cliente.cartao.Fatura.add(context.AnaliseCompra);
            context.cliente.cartao.limites.LimiteDisponivel -= context.AnaliseCompra.valor;
        }
    }

    @Override 
    public void leave(Instituicao context) {
        
    }
    
}