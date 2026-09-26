package instituicao.States;

public class Analisando extends AbstractState {
    @Override 
    public void enter() {
        System.out.printf("Iniciando análise de compra %s no valor de R$%.2f...\n", context.getCliente().cartao.getCompra().nome, context.getCliente().cartao.getCompra().valor);
        context.AnaliseCompra = context.getCliente().cartao.getCompra();
    }

    @Override
    public void execute() {
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
    public void leave() {
        // Lógica de saída do estado de análise
        System.out.println("...");
    }
    
}