package lesson4.task2;

import java.util.Collection;
import java.util.Date;

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

    public void searchTicket(Date date) {
        if (customer == null) {
            throw new RuntimeException("Для поиска билетов нужна авторизация.");
        }
        customer.setTickets(ticketProvider.searchTicket(customer.getId(), new Date()));
    }

    public void logIn(String login, String password) throws Exception {
        try {
            this.customer = customerProvider.getCustomer(login, password);
            System.out.printf("Пользователь %s %s вошел в систему\n", customer.getName(), customer.getSurname());
        } catch (RuntimeException e) {
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
        if (ticketProvider.buyTicket(customer.getId(), cardNo)) {
            Ticket ticket = new Ticket(this.customer.getId(), ticketType);
            customer.addNewTicket(ticket);
            System.out.println("Покупка билета выполенена успешно:");
            System.out.println(ticket);
        } else {
            throw new RuntimeException("Ошибка при покупке билета.");
        }
    }


    //endregion
    //region Fields
    private Customer customer;
    private final TicketProvider ticketProvider;

    private final CustomerProvider customerProvider;
    //endregion
}
