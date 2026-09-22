package instituição.States;

public class OciosoState extends AbstractState {
    @Override 
    public void enter() {
        // Lógica de entrada no estado de ocioso
        System.err.println("Estaremos sempre a disposição para a avaliação para futuras compras");
    }

    @Override
    public void execute() {
        // Lógica de execução do estado de ocioso
        System.out.println("Ainda em espera de compras para análise.");
    }

    @Override 
    public void leave() {
        // Lógica de saída do estado de ocioso
    
    }
}
