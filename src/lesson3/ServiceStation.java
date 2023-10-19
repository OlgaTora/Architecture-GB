package lesson3;

public class ServiceStation implements Repairing {

    @Override
    public void changeOil() {
        System.out.println("Замена масла");
    }

    @Override
    public void repairSuspension() {
        System.out.println("Ремонт подвески");
    }

    @Override
    public void repairChassis() {
        System.out.println("Ремонт ходовой");
    }

    @Override
    public String toString() {
        return "СТО1";
    }
}
