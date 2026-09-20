package Cliente.States;

import Cliente.Cliente;

public class Comprando extends AbstractState {

    public Comprando(Cliente context) {
        super(context);
    }

    @Override
    public void enter() {
        System.out.println(context.getNome() + " começou uma compra.");
    }

    @Override
    public void execute() {
        System.out.println(
                "Comprando: " +
                        context.getCompraAtual().getProduto() +
                        " - R$ " +
                        context.getCompraAtual().getValor()
        );
    }

    @Override
    public void leave() {
        System.out.println(context.getNome() + " saiu do estado Comprando.");
    }
}