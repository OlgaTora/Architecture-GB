package lesson4.task2;

import java.util.Collection;

public class Customer {
    //region Constructor

    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Customer() {
        ;
    }

    //endregion
    //region Properties
    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addNewTicket(Ticket ticket){
        this.tickets.add(ticket);
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", tickets=" + tickets +
                '}';
    }

    //endregion

    //region Fields
    private static int counter;
    private final int id;
    private String name;
    private String surname;

    private Collection<Ticket> tickets;

    {
        id = ++counter;
    }
    //endregion
}
