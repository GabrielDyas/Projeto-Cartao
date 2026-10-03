package cliente.states;

import Objetos.AbstractState;
import Objetos.Produto;
import cliente.Cliente;


public class Comprando extends AbstractState<Cliente> {
    public Produto produto;

    public Comprando(Cliente cliente) {
        super(cliente);
    }

    @Override 
    public void enter(Cliente context) {
        // Lógica de entrada no estado Comprando
        context.comprou = true;
        System.out.println("Analisando produto para compra...");
    }

    @Override
    public void execute(Cliente context) {
        // Lógica de execução do estado Comprando
        context.cartao.compra = context.cartao.getCompra();
        System.out.printf("Cliente está comprando: %s no valor de R$%.2f\n", context.cartao.compra.nome, context.cartao.compra.valor);
    }

    @Override
    public void leave(Cliente context) {
        context.cartao.compra = null; // Limpa a compra após sair do estado 
    }
}
