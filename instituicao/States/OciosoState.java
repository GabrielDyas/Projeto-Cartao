package instituicao.States;

import instituicao.Instituicao;

public class OciosoState extends AbstractState {
    
    public OciosoState(Instituicao context) {
        super(context); // Envia a instituição para o AbstractState
    }

    @Override 
    public void enter() {
       System.out.println("Sem solicitações pendentes.");
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
