package lesson2.memento;

import java.util.Date;

public class Memento {

    public Memento(State state, int lifes, Weapon weapon) {
        this.state = state;
        this.lifes = lifes;
        this.weapon = weapon;
    }

    public State getState() {
        return state;
    }

    public int getLifes() {
        return lifes;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public String toString() {
        return "Memento{" +
                "state=" + state +
                ", lifes=" + lifes +
                ", weapon=" + weapon +
                ", date=" + date +
                '}';
    }

    private State state;
    private int lifes;
    private Weapon weapon;
    private Date date = new Date();
}
