package lesson2.memento;

public class Caretaker {

    public Caretaker() {
    }

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
    private Memento memento;

}
