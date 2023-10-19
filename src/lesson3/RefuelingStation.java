package lesson3;

public class RefuelingStation implements Refueling{

    public void processfuel(FuelType fuelType) {
        switch (fuelType){
            case Diesel -> System.out.println("Заправка дизельным топливом");
            case Gasoline -> System.out.println("Заправка бензином");
        }
    }

    @Override
    public String toString() {
        return "Заправка1";
    }

    @Override
    public void fuel(FuelType fuelType) {
        processfuel(fuelType);
    }
}
