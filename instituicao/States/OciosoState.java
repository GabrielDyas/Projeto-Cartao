package instituicao.States;

public class OciosoState extends AbstractState {
    @Override 
    public void enter() {
       System.out.println(".");
    }

    @Override
    public void execute() {
        System.out.println("Aguardando novas solicitações.");
    }

    @Override 
    public void leave() {
        System.out.println("Solicitação recebida, iniciando análise.");
    }
}
