package cliente.States;

public class Comprando extends AbstractState {
    @Override 
    public void enter()
    {
        // Lógica de entrada no estado Comprando
        System.out.println("Cliente entrou no estado comprando.");
    }

    @Override
    public void execute()
    {
        // Lógica de execução do estado Comprando
        System.out.println("Cliente executou comprando.");

    }

    @Override
    public void leave()
    {
        // Lógica de saída do estado Comprando
        System.out.println("Cliente terminou a compra.");
    }
    
}
