package Objetos;
import Objetos.Produto;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Produto {
    public String nome;
    public double valor;
    public boolean situacao = false;
    
    public static Produto criarProduto() {
        List<Produto> produtos = new ArrayList<>();
        List<String> linhas;
        try {
            linhas = Files.readAllLines(Paths.get("produtos.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException("Não foi possível ler o arquivo produtos.txt.", e);
        }

        for (int i = 0; i < linhas.size(); i++) {
            String linha = linhas.get(i).trim();
            if (linha.isEmpty()) {
                continue;
            }

            int separador = linha.lastIndexOf(',');
            if (separador < 1 || separador == linha.length() - 1) {
                throw new IllegalStateException("Formato inválido em produtos.txt, linha " + (i + 1) + ".");
            }

            String nome = linha.substring(0, separador).trim();
            String valorTexto = linha.substring(separador + 1).trim();
            try {
                produtos.add(new Produto(nome, Double.parseDouble(valorTexto)));
            } catch (NumberFormatException e) {
                throw new IllegalStateException("Preço inválido em produtos.txt, linha " + (i + 1) + ".", e);
            }
        }

        if (produtos.isEmpty()) {
            throw new IllegalStateException("O arquivo produtos.txt não contém produtos.");
        }

        Produto produto = produtos.get(ThreadLocalRandom.current().nextInt(produtos.size()));
        return produto;
    }

    public Produto(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }
    

    
}
