package Objetos;
import java.util.List;

public class Cartao {
    public Limites limites;
    public List<Produto> Fatura;
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