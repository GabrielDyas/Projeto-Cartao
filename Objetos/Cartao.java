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
        float limiti = 0;
        limiti = limites.LimiteDisponivel;
        return limiti;
    }

    //fazer alguma forma para aleatorizar isso, com base em uma lista de produtos
    public Produto getCompra() {
        return compra = new Produto("Produto Exemplo", 100.0);
    }

}
