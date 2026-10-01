package Objetos;
import java.util.List;
import java.util.ArrayList; 

public class Cartao {
    public Limites limites;
    public List<Produto> Fatura = new ArrayList<>();;
    public Produto compra;


    public Cartao(Limites limites) {
        this.limites = limites;
    }
       
    public float getLimite(){
        return limites.LimiteDisponivel;
    }

    public Produto getCompra() {
        return compra = Produto.CriarProduto();
    }
}