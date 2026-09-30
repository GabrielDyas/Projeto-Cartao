package cliente.states;

import Objetos.Produto;
import cliente.Cliente;


public class Comprando extends AbstractState {
    public Produto produto;

    public Comprando(Cliente cliente) {
        super(cliente);
    }

    @Override 
    public void enter() {
        // Lógica de entrada no estado Comprando
        System.out.println("Analisando produto para compra...");
    }

    @Override
    public void execute() {
        // Lógica de execução do estado Comprando
        context.cartao.compra = context.cartao.getCompra();
        System.out.printf("Cliente está comprando: %s no valor de R$%.2f\n", context.cartao.compra.nome, context.cartao.compra.valor);
    }

    @Override
    public void leave() {
        // Lógica de saída do estado Comprando
        System.out.printf("Esperando resposta da instituição da compra: %s\n", context.cartao.compra != null ? context.cartao.compra.nome : "Nenhum");
        context.cartao.compra = null; // Limpa a compra após sair do estado 
    }
    
}
