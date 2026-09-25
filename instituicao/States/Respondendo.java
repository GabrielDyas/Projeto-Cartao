package instituicao.States;


public class Respondendo extends AbstractState {
    @Override 
    public void enter() {
        // Lógica de entrada no estado de resposta
        System.out.println("Solicitação de compra feito, vamos analizar.");
        }

    @Override
    public void execute() {

        if (context.getAnaliseCompra().situacao) {
            System.out.printf( "Compra de(a) %s no valor de R$%.2f aprovada." , context.getAnaliseCompra().nome, context.getAnaliseCompra().valor );
        } else {
            System.out.printf( "Compra de(a) %s no valor de R$%.2f negada." , context.getAnaliseCompra().nome, context.getAnaliseCompra().valor );
        }

    }

    @Override 
    public void leave() {
        System.out.printf( "A compra de(a) %s no valor de R$%.2f está em análise, pedimos que aguerde a resposta." , context.getAnaliseCompra().nome, context.getAnaliseCompra().valor );
    }
}
