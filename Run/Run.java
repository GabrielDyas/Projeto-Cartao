package Run;
//import cliente.Cliente;
//import instituicao.Instituicao;
import Objetos.Produto;

public class Run {
    public static void main(String[] args) {
        //Cliente cliente = new Cliente();
        // Instituicao instituicao = new Instituicao("Banco", cliente);

        // Simulação de interações do cliente com a instituição
        /*while (true) {
            
        }*/


       for (int i = 1; i <= 3; i++) {
        Produto produto = Produto.criarProduto();
        System.out.printf("%d. %s - R$ %.2f%n", i, produto.nome, produto.valor);
        }

    }


}
