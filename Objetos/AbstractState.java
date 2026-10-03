package Objetos;

public abstract class AbstractState<T> implements State<T> {
    protected T context; 

    public AbstractState(T context) {
        this.context = context; //[cite: 10]
    }

    @Override
    public void enter(T context) {
        System.out.println("Entrou em um estado."); 
    }

    @Override
    public void execute(T context) {
        System.out.println("Executou em um estado."); 
    }

    @Override
    public void leave(T context) {
        System.out.println("Saiu de um estado."); 
    }
}