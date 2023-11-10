package lesson8.Models;

import java.util.Date;

public class Reservation {

    public Reservation(int tableNo, Date date, String name) {
        this.tableNo = tableNo;
        this.date = date;
        this.name = name;
    }

    private static int counter = 1000;
    private final int id;

    {
        id = ++counter;
    }

    private final int tableNo;

    private final Date date;

    private String name;
    private ReservationStatus status = ReservationStatus.ACTIVE;

    public Date getDate() {
        return date;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", tableNo=" + tableNo +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
