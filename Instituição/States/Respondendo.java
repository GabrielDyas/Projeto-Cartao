package instituição.States;

public class Respondendo extends AbstractState {
    @Override 
    public void enter() {
        // Lógica de entrada no estado de resposta
        System.out.println("Solicitação de compra feito, vamos analizar.");

          }

    @Override
    public void execute() {
        // Lógica de resposta à solicitação
        System.out.printf("A compra de(a) %s no valor de R$%.f2 está em análise, pedimos que aguerde a resposta.");
    }

    @Override 
    public void leave() {
        // Lógica de saída do estado de resposta
        System.out.println("Todas as compras foram analizadas.");
    }
    
}
