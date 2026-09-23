package Objetos;
import Objetos.Produto;
import java.util.List;

public class Cartao {
    public Limites limites;
    public List<Produto> Fatura;

    public Cartao(Limites limites) {
        this.limites = limites;
    }
       
    public float getLimite(){
        float limiti = 0;
        limiti = limites.LimiteDisponivel;
        return limiti;
    }
}
