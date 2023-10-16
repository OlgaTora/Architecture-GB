package lesson2.memento;

public class Program {
    public static void main(String[] args) {
        Hero hero1 = new Hero(State.ALIVE, 5, Weapon.BOMB);
        System.out.println(hero1);
        Caretaker caretaker = new Caretaker();
        System.out.println("Save hero at the moment");
        Memento memento = hero1.saveHero();
        caretaker.setMemento(memento);
        System.out.println(memento);
        System.out.println("Change state of hero");
        hero1.setState(State.PRISONER);
        hero1.setWeapon(Weapon.GUN);
        System.out.println(hero1);
        hero1.restoreHero(caretaker.getMemento());
        System.out.println("Restore state of hero");
        System.out.println(hero1);
    }
}
