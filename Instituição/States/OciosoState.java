package instituição.States;

public class OciosoState extends AbstractState {
    @Override 
    public void enter() {
       System.out.println("Análise encerrada, aguardando novas solicitações.");
    }

    @Override
    public void execute() {
        System.out.println("Estado Ocioso: Aguardando novas solicitações.");
    }

    @Override 
    public void leave() {
        System.out.println("Solicitação recebida, iniciando análise.");
    }
}
