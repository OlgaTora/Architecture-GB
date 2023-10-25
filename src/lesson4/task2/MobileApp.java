package lesson4.task2;

import java.util.Collection;

public class MobileApp {
    //region Constructor
    public MobileApp(TicketProvider ticketProvider, CustomerProvider customerProvider) {
        this.ticketProvider = ticketProvider;
        this.customerProvider = customerProvider;
    }

    //endregion
    //region Properties


    public void getTickets() throws Exception {
        if (customer == null) {
            throw new RuntimeException("Для просмотра билетов нужна авторизация.");
        }
        try {
            Collection<Ticket> tickets = customer.getTickets();
            System.out.println("Список билетов:");
            System.out.println(tickets);
        } catch (RuntimeException e) {
            throw new Exception("Ошибка при получении данных о билетах.", e.fillInStackTrace());
        }
    }

    public void searchTicket(String date) throws Exception {
        if (customer == null) {
            throw new RuntimeException("Для поиска билетов нужна авторизация.");
        }
        try {
            System.out.println("Ищем билеты...");
            Collection<Ticket> searchTickets = customer.searchTickets(ticketProvider.searchTicket(customer.getId(), date));
            System.out.println("Найдены билеты:");
            System.out.println(searchTickets);
        } catch (RuntimeException e) {
            throw new Exception("Ошибка при получении данных о билетах.");
        }
    }

    public void logIn(String login, String password) throws Exception {
        try {
            if (this.customer == null) {
                this.customer = customerProvider.getCustomer(login, password);
                System.out.printf("Пользователь %s %s вошел в систему\n", customer.getName(), customer.getSurname());
            } else {
                System.out.printf("Пользователь %s %s уже в системе\n", customer.getName(), customer.getSurname());
            }

        } catch (
                RuntimeException e) {
            throw new Exception("Ошибка при получении данных о пользователе.", e.fillInStackTrace());
        }

    }

    public void logOut() {
        this.customer = null;
        System.out.println("Пользователь вышел из системы");
    }

    public void buyTicket(String cardNo, TicketType ticketType) {
        if (customer == null) {
            throw new RuntimeException("Для покупки билета нужна авторизация.");
        }
        System.out.println("Идет покупка билета...");
        try {
            Ticket ticket = ticketProvider.buyTicket(customer.getId(), cardNo, ticketType);
            customer.addNewTicket(ticket);
            System.out.println("Билет добавлен в ваши билеты:");
            System.out.println(ticket);
        } catch (RuntimeException e){
            throw new RuntimeException("Ошибка при покупке билета.", e.fillInStackTrace());
    }

}

    //endregion
    //region Fields
    private Customer customer;
    private final TicketProvider ticketProvider;

    private final CustomerProvider customerProvider;
    //endregion
}
