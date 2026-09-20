package cliente.States;

import cliente.Cliente;
import Objetos.Produto;

public class Comprando extends AbstractState {

    private Produto produto;

    public Comprando(Cliente cliente) {
        super(cliente);
    }

    public Produto criarProduto(String tipo, double preco) {

        produto = new Produto(tipo, preco);

        return produto;
    }

    public Produto getProduto() {
        return produto;
    }

    @Override
    public void enter() {
        System.out.println("Cliente entrou no estado Comprando.");
    }

    @Override
    public void execute() {
        System.out.println("Cliente está comprando.");
    }

    @Override
    public void leave() {
        System.out.println("Cliente saiu do estado Comprando.");
    }
}