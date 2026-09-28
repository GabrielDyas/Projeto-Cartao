package Run;

import cliente.Cliente;
import Objetos.Produto;

public class Run {
    public static void main(String[] args) {
        System.out.println("Teste: três produtos aleatórios");
        for (int i = 1; i <= 3; i++) {
            Produto produto = Produto.criarProduto();
            System.out.printf("%d. %s - R$ %.2f%n", i, produto.nome, produto.valor);
        }

        Cliente cliente = new Cliente();
        System.out.println("\nSimulação do cliente");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("Ciclo %d - estado atual: %s%n",
                    i, cliente.getCurrentState().getClass().getSimpleName());
            Produto produtoComprado = cliente.execute();
            if (produtoComprado != null) {
                System.out.printf("Compra realizada: %s - R$ %.2f%n",
                        produtoComprado.nome, produtoComprado.valor);
            }
        }
    }
}
