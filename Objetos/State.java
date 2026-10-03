package Objetos;

public interface State<T> {
    void enter(T context);          
    void execute(T context); 
    void leave(T context);           
}