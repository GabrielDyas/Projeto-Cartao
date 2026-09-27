package cliente.states;

import Objetos.Produto;
import cliente.Cliente;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Comprando extends AbstractState {
    private Produto produto;

    public Comprando(Cliente cliente) {
        super(cliente);
    }

    public Produto criarProduto() {
        List<Produto> produtos = new ArrayList<>();
        List<String> linhas;
        try {
            linhas = Files.readAllLines(Paths.get("cliente", "produtos.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException("Não foi possível ler o arquivo cliente/produtos.txt.", e);
        }

        for (int i = 0; i < linhas.size(); i++) {
            String linha = linhas.get(i).trim();
            if (linha.isEmpty()) {
                continue;
            }

            int separador = linha.lastIndexOf(',');
            if (separador < 1 || separador == linha.length() - 1) {
                throw new IllegalStateException("Formato inválido em cliente/produtos.txt, linha " + (i + 1) + ".");
            }

            String nome = linha.substring(0, separador).trim();
            String valorTexto = linha.substring(separador + 1).trim();
            try {
                produtos.add(new Produto(nome, Double.parseDouble(valorTexto)));
            } catch (NumberFormatException e) {
                throw new IllegalStateException("Preço inválido em cliente/produtos.txt, linha " + (i + 1) + ".", e);
            }
        }

        if (produtos.isEmpty()) {
            throw new IllegalStateException("O arquivo cliente/produtos.txt não contém produtos.");
        }

        produto = produtos.get(ThreadLocalRandom.current().nextInt(produtos.size()));
        return produto;
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
