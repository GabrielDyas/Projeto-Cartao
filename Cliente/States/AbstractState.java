package cliente.States;
import Objetos.State;

public abstract class AbstractState implements State {
    @Override
    public void enter()
    {
        System.out.println("Cliente entrou em um estado.");
    }

    @Override
    public void execute()
    {
        System.out.println("Cliente executou um estado.");
    }

    @Override
    public void leave()
    {
        System.out.println("Cliente saiu em um estado.");
    }
}