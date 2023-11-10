package lesson8.Views;

import lesson8.Models.Reservation;
import lesson8.Models.ReservationStatus;
import lesson8.Models.Table;
import lesson8.Presenters.View;
import lesson8.Presenters.ViewObserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private Collection<ViewObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(ViewObserver observer) {
        observers.add(observer);
    }

    @Override
    public void showTables(Collection<Table> tables) {
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    public void showAllReservationsResult(Collection<Reservation> reservations) {
        if (reservations == null) {
            System.out.printf("Резервов нет.");
        } else {
            System.out.println("Список резервов:");
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        }
    }

    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0)
            System.out.printf("Столик успешно забронирован. Номер резерва #%d\n", reservationNo);
        else
            System.out.println("Невозможно забронировать столик.\nПовторите попытку позже.");
    }

    @Override
    public void showChangeReservationTableResult(int reservationNo) {
        if (reservationNo > 0)
            System.out.printf("Бронь успешно изменена. Номер нового резерва #%d\n", reservationNo);
        else
            System.out.println("Невозможно изменить бронь.\nПовторите попытку позже.");
    }

    @Override
    public void showRemoveReservationTableResult(int reservationNo) {
        if (reservationNo > 0)
            System.out.printf("Бронь #%d успешно удалена\n", reservationNo);
        else
            System.out.println("Невозможно удалить бронь.\nПовторите попытку позже.");
    }

    public void reservationTable(Date reservtionDate, int tableNo, String name) {
        for (ViewObserver observer : observers)
            observer.onReservationTable(reservtionDate, tableNo, name);
    }

    public void changeReservationTable(int oldReservation, Date reservtionDate, int tableNo, String name) {
        for (ViewObserver observer : observers)
            observer.onChangeReservationTable(oldReservation, reservtionDate, tableNo, name);
    }

    public void removeReservationTable(int reservationId) {
        for (ViewObserver observer : observers)
            observer.onRemoveReservationTable(reservationId);
    }
    public void showAllReservations(){
        for (ViewObserver observer : observers)
            observer.onShowAllReservations();
    }
}
