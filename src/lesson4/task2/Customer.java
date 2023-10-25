package lesson4.task2;

import java.util.ArrayList;
import java.util.Collection;

public class Customer {
    //region Constructor
    public Customer(String name, String surname, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }
    //endregion
    //region Properties
    public Collection<Ticket> getTickets() {
        // Постусловие
        if (tickets == null) {
            throw new RuntimeException("У пользователя нет билетов.");
        }
        return tickets;
    }

    public Collection<Ticket> searchTickets(Collection<Ticket> tickets)
    {
        System.out.println("Печать из кастомер");
        return tickets;
    }

    public void addNewTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
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
    private String password;
    private String login;
    private Collection<Ticket> tickets = new ArrayList<>();

    {
        id = ++counter;
    }
    //endregion
}
