package instituicao.States;
import instituicao.Instituicao;
import Objetos.AbstractState;
public class Analisando extends AbstractState<Instituicao> {

    public Analisando(Instituicao context) {
        super(context); 
    }

    @Override 
    public void enter(Instituicao context) {
        System.out.printf("Iniciando análise de compra %s no valor de R$%.2f...\n", context.getCliente().cartao.compra.nome, context.getCliente().cartao.compra.valor);
        context.AnaliseCompra = context.getCliente().cartao.compra; // Armazena a compra que está sendo analisada
        context.analisandoCompra = true; // Indica que a análise está em andamento
    }

    @Override
    public void execute(Instituicao context) {
        System.err.println("Analisando compra...");
        if(context.getCliente().cartao.getLimite() < context.AnaliseCompra.valor) {
            // Lógica para quando o limite é insuficiente
            context.AnaliseCompra.situacao = false;
            context.getCliente().cartao.Fatura.add(context.AnaliseCompra);
        } else {
            // Lógica para quando o limite é suficiente
            context.AnaliseCompra.situacao = true;
            context.getCliente().cartao.Fatura.add(context.AnaliseCompra);
            context.getCliente().cartao.limites.LimiteDisponivel -= context.AnaliseCompra.valor;
        }
    }

    @Override 
    public void leave(Instituicao context) {
        
    }
    
}