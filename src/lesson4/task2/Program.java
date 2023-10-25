package lesson4.task2;

public class Program {

    /**
     * Разработать контракты и компоненты системы "Покупка онлайн билетов на автобус в час пик".
     * <p>
     * 1.  Предусловия.
     * 2.  Постусловия.
     * 3.  Инвариант.
     * 4.  Определить абстрактные и конкретные классы.
     * 5.  Определить интерфейсы.
     * 6.  Реализовать наследование.
     * 7.  Выявить компоненты.
     * 8.  Разработать Диаграмму компонент использую нотацию UML 2.0. Общая без деталей.
     */
    public static void main(String[] args) throws Exception {
        Core core = new Core();
        MobileApp mobileApp = new MobileApp(core.getTicketProvider(), core.getCustomerProvider());
        BusStation busStation = new BusStation(core.getTicketProvider());
        mobileApp.logIn("surname1", "surname1");
        mobileApp.getTickets();
        mobileApp.buyTicket("1000000000000099", TicketType.METRO);
        mobileApp.getTickets();
        mobileApp.searchTicket("25-10-2023");
        mobileApp.logIn("surname1", "surnam1");
        mobileApp.logOut();
        //mobileApp.logIn("surname1", "surnam1");
        mobileApp.logIn("surname2", "surname2");
        mobileApp.searchTicket("25-10-2023");
    }
}


