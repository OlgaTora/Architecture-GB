package lesson8.Presenters;

import lesson8.Models.Reservation;
import lesson8.Models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {

    Collection<Table> loadTables();

    int reservationTable(Date reservationDate, int tableNo, String name);

    int changeReservationTable(int oldReservation, Date reservtionDate, int tableNo, String name);

    int removeReservationTable(int reservationId);

    Collection<Reservation> loadReservations();

}
