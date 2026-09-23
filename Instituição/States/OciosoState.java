package instituição.States;

public class OciosoState extends AbstractState {
    @Override 
    public void enter() {

       System.out.println("Análise encerrada, aguardando novas solicitações.");

        // Lógica de entrada no estado de ocioso
        System.err.println("Estaremos sempre a disposição para a avaliação para futuras compras");

    }

    @Override
    public void execute() {

        System.out.println("Estado Ocioso: Aguardando novas solicitações.");

        // Lógica de execução do estado de ocioso
        System.out.println("Ainda em espera de compras para análise.");

    }

    @Override 
    public void leave() {
        System.out.println("Solicitação recebida, iniciando análise.");
    }
}
