package lesson4.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class BaseFiller {

    private Collection<Ticket> tickets = new ArrayList<>();
    private Collection<Customer> customers = new ArrayList<>();

    private int countCustomers;
    private int countTickets;

    public BaseFiller(int countCustomers, int countTickets) {
        this.countCustomers = countCustomers;
        this.countTickets = countTickets;

        for (int i = 1; i <= countCustomers; i++) {
            String name = String.format("name %d", i);
            String surname = String.format("surname %d", i);
            Customer customer = new Customer(name, surname);
            for (int j = 0; j < new Random().nextInt(0, countTickets); j++) {
                Ticket ticket = new Ticket();
                customer.addNewTicket(ticket);
                tickets.add(ticket);
            }
        }

        //customer1.getTickets().add(ticket1);
        //customer1.getTickets().add(ticket2);


    }
}
