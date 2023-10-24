package lesson4.task2;

import java.util.Collection;

public class CustomerProvider {

    private final Database database;

    public CustomerProvider(Database database) {
        this.database = database;
    }

    public Customer getCustomer(String login, String password) {
        // Предусловие
        if (login.length() < 6)
        {
            throw new RuntimeException("Некорректный логин.");
        }

        // Выполнение подпрограммы
        Collection<Customer> customers = database.getCustomers();
        Customer customerInfo = null;
        for (Customer customer : customers) {
            if (customer.getLogin().equals(login) && customer.getPassword().equals(password)) {
                customerInfo = customer;
            }
        }
        // Постусловие
        if (customerInfo == null){
            throw new RuntimeException("Неверный логин или пароль.");
        }
        return customerInfo;
    }
}
