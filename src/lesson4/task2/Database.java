package lesson4.task2;

import java.util.*;

public class Database {
    // region Fields
    private static int counter;
    private Collection<Ticket> tickets = new ArrayList<>();
    private Collection<Customer> customers = new ArrayList<>();
    private int countCustomers = 10;
    private int countTickets = 10;
    //endregion
    // region Constructor
    {
        List<TicketType> ticketTypes = Arrays.asList(TicketType.values());
        for (int i = 1; i <= this.countCustomers; i++) {
            String name = String.format("name %d", i);
            String surname = String.format("surname %d", i);
            String login = String.format("surname%d", i);
            Customer customer = new Customer(name, surname, login, login);
            for (int j = 0; j < new Random().nextInt(0, this.countTickets); j++) {
                Random random = new Random();
                Ticket ticket = new Ticket(i, ticketTypes.get(random.nextInt(ticketTypes.size())));
                customer.addNewTicket(ticket);
                this.tickets.add(ticket);
            }
            this.customers.add(customer);
        }
    }

    //endregion
    //region Properties
    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    /**
     * Получить актуальную стоимость билета
     *
     * @return
     */
    public double getTicketAmount() {
        return 55;
    }

    /**
     * Получить идентификатор заявки на покупку билета
     *
     * @return
     */
    public int createTicketOrder(int clientId) {
        return ++counter;
    }

    //endregion
}
