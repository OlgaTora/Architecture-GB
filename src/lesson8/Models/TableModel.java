package lesson8.Models;

import lesson8.Presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {

    private Collection<Table> tables;

    @Override
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(tableNo, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика");
    }

    @Override
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            for (Reservation reservation : table.getReservations()) {
                if (reservation.getId() == oldReservation) {
                    System.out.println(table);
                    reservation.setStatus(ReservationStatus.CANCEL);
                    Reservation newReservation = new Reservation(tableNo, reservationDate, name);
                    table.getReservations().add(newReservation);
                    return newReservation.getId();
                }
            }
        }
        throw new RuntimeException("Некорректный номер брони");
    }

    @Override
    public int removeReservationTable(int reservationId) {
        for (Table table : tables) {
            for (Reservation reservation : table.getReservations()) {
                if (reservation.getId() == reservationId) {
                    reservation.setStatus(ReservationStatus.CANCEL);
                    return reservationId;
                }
            }
        }
        throw new RuntimeException("Некорректный номер брони");
    }

    @Override
    public Collection<Reservation> loadReservations() {
        Collection<Reservation> reservations = new ArrayList<>();
        for (Table table : tables) {
            reservations.addAll(table.getReservations());
        }
        return reservations;
    }
}
