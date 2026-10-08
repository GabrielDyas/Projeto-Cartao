package Objetos;
import java.util.List;
import java.util.ArrayList; 

public class Cartao {
    public Limites limites;
    public final int FECHAMENTO_FATURA = 5;
    public List<Produto> Fatura = new ArrayList<>();;
    public Produto compra;


    public Cartao(Limites limites) {
        this.limites = limites;
    }

    public Produto getCompra() {
        return compra = Produto.CriarProduto();
    }

    public void FechamentoFatura() {
        System.out.println("Fatura fechada e limite restabelecido!");
        System.out.println("Sitação das compras:");
        for (Produto produto : this.Fatura) {
            System.out.printf("Compra: %s | Valor: R$%.2f | Situação: %s\n", produto.nome, produto.valor, produto.situacao ? "Aprovada" : "Rejeitada");
        }
        this.Fatura.clear();
        this.limites.LimiteDisponivel = this.limites.LIMITE_TOTAL;
    }
}