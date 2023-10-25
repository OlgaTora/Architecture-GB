package lesson4.task2;

import java.util.ArrayList;
import java.util.Collection;

public class TicketProvider {
    //region Constructor
    public TicketProvider(Database database, PaymentProvider paymentProvider) {
        this.database = database;
        this.paymentProvider = paymentProvider;
    }

    //endregion
    //region Properties
    public Collection<Ticket> searchTicket(int clientId, String date) {
        Collection<Ticket> searchTickets = new ArrayList<>();
        for (Ticket ticket : database.getTickets()) {
            if (ticket.getCustomerId() == clientId && ticket.getDate().equals(date))
                searchTickets.add(ticket);
        }
        if (searchTickets.isEmpty()) {
            throw new RuntimeException("У пользователя нет билетов на эту дату.");
        }
        return searchTickets;
    }

    public Ticket buyTicket(int clientId, String cardNo, TicketType ticketType) {
        int orderId = database.createTicketOrder(clientId);
        double amount = database.getTicketAmount();
        Ticket ticket = null;
        if (paymentProvider.buyTicket(orderId, cardNo, amount)) {
            ticket = new Ticket(clientId, ticketType);
            database.addNewTicketToBase(ticket);
            System.out.println("Покупка билета выполенена успешно.");
        }
        if (ticket == null) {
            System.out.println("Покупка билета не выполенена.");
        }
        return ticket;
    }

    public boolean checkTicket(String qrcode) {
        for (Ticket ticket : database.getTickets()) {
            if (ticket.getQrcode().equals(qrcode)) {
                ticket.setEnable(false);
                // Save database ...
                return true;
            }
        }
        return false;
    }

    //endregion
    //region Fields
    private final Database database;
    private final PaymentProvider paymentProvider;
    //endregion
}
