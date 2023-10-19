package lesson3;

public class CarWashStation implements Wiping {
    @Override
    public void washCar() {
        System.out.println("Идет мойка машины");
    }

    @Override
    public void wipCar() {
        wipMirrors();
        wipHeadlights();
        wipWindshield();
    }

    public void wipMirrors() {
        System.out.println("Мойка зеркал");
    }

    public void wipWindshield() {
        System.out.println("Мойка дворников");

    }

    public void wipHeadlights() {
        System.out.println("Мойка фар");
    }

    public String toString() {
        return "Мойка машины 1";
    }
}
