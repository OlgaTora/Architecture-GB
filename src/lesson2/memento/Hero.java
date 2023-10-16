package lesson2.memento;

public class Hero {

    public Hero(State state, int lifes, Weapon weapon) {
        this.state = state;
        this.lifes = lifes;
        this.weapon = weapon;
    }

    public Memento saveHero(){
        return new Memento(state, lifes, weapon);
    }

    public void restoreHero(Memento memento){
        this.state = memento.getState();
        this.lifes = memento.getLifes();
        this.weapon = memento.getWeapon();
    }
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getLifes() {
        return lifes;
    }

    public void setLifes(int lifes) {
        this.lifes = lifes;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "state=" + state +
                ", lifes=" + lifes +
                ", weapon=" + weapon +
                '}';
    }

    private State state;
    private int lifes;
    private Weapon weapon;
}
