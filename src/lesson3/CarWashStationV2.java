package lesson3;

public class CarWashStationV2 implements Wiping {
    @Override
    public void washCar() {
        System.out.println("Идет мойка машины");
    }

    @Override
    public void wipCar() {
        wipMirrors();
    }

    public void wipMirrors() {
        System.out.println("Мойка зеркал");
    }

    @Override
    public String toString() {
        return "Мойка машины 2";
    }
}
