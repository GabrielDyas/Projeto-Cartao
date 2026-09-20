package Objetos;

public class Produto {

    private String tipo;
    private double preco;
    //private time data;

    public Produto(String tipo, double preco) {
        this.tipo = tipo;
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPreco() {
        return preco;
    }
    /*public time getData(){
        aqui insere lógica de data
    }*/
}