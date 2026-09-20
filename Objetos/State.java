package Objetos;

public interface State {
    void enter();   // Executado ao entrar no estado
    void execute(); // Executado a cada ciclo
    void leave();   // Executado ao sair do estado
}