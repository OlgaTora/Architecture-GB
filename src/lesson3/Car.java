package lesson3;

import java.awt.*;

public abstract class Car {

    // region Properties

    public void setServiceStation(Repairing serviceStation){
        this.repairing = serviceStation;
        System.out.printf("Машина %s %s приехала на сервис %s\n", this.model, this.make, this.repairing);

    }
    /**
     * Обслужить автомобиль
     */

    public void maintenance(){
        if(repairing!=null){
            repairing.changeOil();
            repairing.repairChassis();
            repairing.repairSuspension();
        }
    }
    public void setCarWash(Wiping carWash) {
        this.wiping = carWash;
        System.out.printf("Машина %s %s приехала на мойку %s\n", this.model, this.make, this.wiping);
    }

    /**
     * Помыть автомобиль
     */

    public void wash() {
        if (wiping != null) {
            wiping.washCar();
        }
    }
    public void wip() {
        if (wiping != null) {
            wiping.wipCar();
        }
    }
    public void setRefuelingStation(Refueling refuelingStation) {
        this.refueling = refuelingStation;
        System.out.printf("Машина %s %s приехала на заправку %s\n", this.model, this.make, this.refueling);
    }

    /**
     * Заправить автомобиль
     */
    public void fuel() {
        if (refueling != null) {
            refueling.fuel(fuelType);
        }
    }

    @Override
    public String toString() {
        return make + " " + model;
    }

    public void setGearboxType(GearboxType gearboxType) {
        this.gearboxType = gearboxType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    protected void setWheelsCount(int wheelsCount) {
        this.wheelsCount = wheelsCount;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    // Движение
    public abstract void movement();

    // Переключение передач
    public abstract boolean gearShifting();

    // Включение фар
    public abstract boolean switchHeadlights();

    // Включение дворников
    public abstract boolean switchWipers();
    // endregion

    //region Constructors

    public Car(String make, String model, Color color) {
        this.make = make;
        this.model = model;
        this.color = color;
    }

    //endregion

    //region Fields

    // Марка автомобиля
    private String make;

    // Модель
    private String model;

    // Цвет
    private Color color;

    // Тип
    protected CarType type;

    // Число колес
    private int wheelsCount = 4;

    // Тип топлива
    protected FuelType fuelType = FuelType.Gasoline;

    // Тип коробки передач
    private GearboxType gearboxType = GearboxType.MT;

    // Объем двигателя
    private double engineCapacity;

    // Состояние противотуманных фар
    private boolean fogLights = false;
    private Refueling refueling;
    private Wiping wiping;

    private Repairing repairing;
    //endregion

}
