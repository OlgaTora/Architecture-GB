package lesson8;

import lesson8.Models.TableModel;
import lesson8.Presenters.BookingPresenter;
import lesson8.Presenters.Model;
import lesson8.Views.BookingView;

import java.util.Date;

public class Program {

    public static void main(String[] args) {
        Model model = new TableModel();
        BookingView view = new BookingView();
        BookingPresenter presenter = new BookingPresenter(model, view);
        presenter.updateTables();

        view.reservationTable(new Date(), 3, "Станислав");
        view.reservationTable(new Date(), 1, "Иван");
        view.reservationTable(new Date(), 4, "Василий");
        view.showAllReservations();
        view.changeReservationTable(1001, new Date(), 2, "Станислав");
        view.showAllReservations();
        view.changeReservationTable(1044, new Date(), 2, "Станислав");
        view.removeReservationTable(1003);
        view.showAllReservations();
    }

}
