package Objetos;

public class Cartao {
    public Limites limites;

    public Cartao(Limites limites) {
        this.limites = limites;
    }
       
    public float getLimite(){
        float limiti = 0;
        limiti = limites.LimiteDisponivel;
        return limiti;
    }
}
