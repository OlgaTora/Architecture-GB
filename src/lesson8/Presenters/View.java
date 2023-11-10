package lesson8.Presenters;

import lesson8.Models.Reservation;
import lesson8.Models.Table;

import java.util.Collection;

public interface View {

    void registerObserver(ViewObserver observer);

    void showTables(Collection<Table> tables);
    void showAllReservationsResult(Collection<Reservation> reservations);

    void showReservationTableResult(int reservationNo);
    void showChangeReservationTableResult(int reservationNo);
    void showRemoveReservationTableResult(int reservationNo);

}
