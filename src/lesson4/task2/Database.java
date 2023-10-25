package lesson4.task2;

import java.util.*;

public class Database {
    // region Fields
    private static int counter;
    private final Collection<Ticket> tickets = new ArrayList<>();
    private final Collection<Customer> customers = new ArrayList<>();
    private final int countCustomers = 10;
    private final int countTickets = 10;
    //endregion
    // region Constructor
    {
        List<TicketType> ticketTypes = Arrays.asList(TicketType.values());
        for (int i = 1; i <= this.countCustomers; i++) {
            String name = String.format("name %d", i);
            String surname = String.format("surname %d", i);
            String login = String.format("surname%d", i);
            Customer customer = new Customer(name, surname, login, login);
            for (int j = 0; j < new Random().nextInt(1, this.countTickets); j++) {
                Random random = new Random();
                Ticket ticket = new Ticket(i, ticketTypes.get(random.nextInt(ticketTypes.size())));
                customer.addNewTicket(ticket);
                addNewTicketToBase(ticket);
            }
            addNewCustomerToBase(customer);
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
    public void addNewCustomerToBase(Customer customer) {
        this.customers.add(customer);
    }

    public void addNewTicketToBase(Ticket ticket) {
        this.tickets.add(ticket);
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
