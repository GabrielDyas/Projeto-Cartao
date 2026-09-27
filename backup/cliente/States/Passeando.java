package cliente.States;

import cliente.Cliente;

public class Passeando extends AbstractState {

    public Passeando(Cliente cliente) {
        super(cliente);
    }

    @Override 
    public void enter()
    {
        // Lógica de entrada no estado Passeando
        System.out.println("Entrando no estado Passeando.");
    }

    @Override
    public void execute()
    {
        //Lógica de execução do estado Passeando
        System.out.println("Executando o estado Passeando.");
    }
    
    @Override
    public void leave()
    {
        // Lógica de saída do estado Passeando
        System.out.println("Saindo do estado Passeando.");
    }
}
