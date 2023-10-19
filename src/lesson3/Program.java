package lesson3;

import java.awt.*;

public class Program {

    /**
     * 1. Спроектировать абстрактный класс «Car» у которого должны
     * быть свойства: марка, модель, цвет, тип кузова, число колёс, тип
     * топлива, тип коробки передач, объём двигателя; методы:
     * движение, обслуживание, переключение передач, включение
     * фар, включение дворников.
     *
     * 2. Создать конкретный автомобиль путём наследования класса
     * «Car».
     *
     * 3. Расширить абстрактный класс «Car», добавить метод: подметать
     * улицу. Создать конкретный автомобиль путём наследования
     * класса «Car». Провести проверку принципа SRP.
     *
     * 4. Расширить абстрактный класс «Car», добавить метод:
     * включение противотуманных фар, перевозка груза. Провести
     * проверку принципа OCP.
     *
     * 5. Создать конкретный автомобиль путём наследования класса
     * «Car», определить число колёс = 3. Провести проверку принципа LSP.
     *
     * 6. Создать конкретный автомобиль путём наследования класса
     * «Car», определить метод «движение» - «полёт». Провести
     * проверку принципа LSP.
     *
     * 7. Создать интерфейс «Заправочная станция», создать метод:
     * заправка топливом.
     *
     * 8. Имплементировать метод интерфейса «Заправочная станция» в
     * конкретный класс «Car».
     *
     * 9. Добавить в интерфейс «Заправочная станция» методы: протирка
     * лобового стекла, протирка фар, протирка зеркал.
    *
     * 10. Имплементировать все методы интерфейса «Заправочная
     * станция» в конкретный класс «Car». Провести проверку
     * принципа ISP. Создать дополнительный/е интерфейсы и
     * имплементировать их в конкретный класс «Car». Провести
     * проверку принципа ISP.
     *
     * 11. Создать путём наследования класса «Car» два
     * автомобиля: с бензиновым и дизельным двигателями,
     * имплементировать метод «Заправка топливом» интерфейса
     * «Заправочная станция». Реализовать заправку каждого
     * автомобиля подходящим топливом. Провести проверку принципа DIP.

     * TODO: Домашнее задание:
     * Доработать приложение, спроектированное на семинаре. Добавить тип, описывающий "автомойку".
     * Продемонстрировать работу получившейся программы,
     * создать несколько типов автомобилей,
     * загнать каждый автомобиль на заправку, а затем и на автомойку.
     * @param args
     */
    public static void main(String[] args) {

        RefuelingStation refuelingStation = new RefuelingStation();
        RefuelingStationV2 refuelingStation2 = new RefuelingStationV2();
        CarWashStation carWashStation1 = new CarWashStation();
        CarWashStationV2 carWashStation2 = new CarWashStationV2();
        ServiceStation serviceStation = new ServiceStation();

        Harvester harvester1 = new Harvester("Forage", "B-123", Color.BLACK);
        Harvester harvester2 = new Harvester("Combine", "A-111", Color.RED);
        SportCar sportCar = new SportCar("Dodge", "Viper", Color.YELLOW);
        CivilianVehicle civilianVehicle = new CivilianVehicle("Moskvich", "3", Color.WHITE);

        harvester1.setRefuelingStation(refuelingStation);
        harvester1.fuel();
        harvester2.setCarWash(carWashStation1);
        harvester2.wash();
        sportCar.setRefuelingStation(refuelingStation2);
        sportCar.fuel();
        sportCar.setCarWash(carWashStation2);
        sportCar.wip();
        civilianVehicle.setCarWash(carWashStation1);
        civilianVehicle.wip();
        civilianVehicle.setServiceStation(serviceStation);
        civilianVehicle.maintenance();
        calculateMaintenance(civilianVehicle);
    }


    public static void calculateMaintenance(Car car){
        double price = car.getWheelsCount() * 1500;
        System.out.printf("Цена шиномонтажа на %s  %.2f\n", car, price);
        }

}
