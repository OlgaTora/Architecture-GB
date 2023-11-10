package lesson8.Presenters;

import lesson8.Models.Reservation;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.registerObserver(this);
    }

    public void updateTables() {
        view.showTables(model.loadTables());
    }

    private void showReservationTableResult(int reservationNo) {
        view.showReservationTableResult(reservationNo);
    }

    private void showChangeReservationTableResult(int reservationNo) {
        view.showChangeReservationTableResult(reservationNo);
    }

    private void showRemoveReservationTableResult(int reservationNo) {
        view.showRemoveReservationTableResult(reservationNo);
    }

    @Override
    public void onReservationTable(Date reservationDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(reservationDate, tableNo, name);
            showReservationTableResult(reservationNo);
        } catch (RuntimeException e) {
            showReservationTableResult(-1);
        }
    }

    @Override
    public void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        try {
            int reservationNo = model.changeReservationTable(oldReservation, reservationDate, tableNo, name);
            showChangeReservationTableResult(reservationNo);
        } catch (RuntimeException e) {
            showChangeReservationTableResult(-1);
        }
    }

    @Override
    public void onRemoveReservationTable(int reservationId) {
        try {
            int reservationNo = model.removeReservationTable(reservationId);
            showRemoveReservationTableResult(reservationNo);
        } catch (RuntimeException e) {
            showRemoveReservationTableResult(-1);
        }
    }

    @Override
    public void onShowAllReservations() {
        Collection<Reservation> reservations = model.loadReservations();
        showAllReservationsResult(reservations);
    }
    public void showAllReservationsResult(Collection<Reservation> reservations) {
        view.showAllReservationsResult(reservations);
    }
}

