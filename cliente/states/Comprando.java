package cliente.states;

import Objetos.Produto;
import cliente.Cliente;

public class Comprando extends AbstractState {
    private Produto produto;

    public Comprando(Cliente cliente) {
        super(cliente);
    }
    
    public Produto getProduto() {
        return produto;
    }

    @Override 
    public void enter() {
        // Lógica de entrada no estado Comprando
        System.out.println("Entrando no estado Comprando");
    }

    @Override
    public void execute() {
        // Lógica de execução do estado Comprando
        System.out.println("Executando o estado Comprando");
    }

    @Override
    public void leave() {
        // Lógica de saída do estado Comprando
        System.out.println("Saindo do estado Comprando");
    }
    
}
