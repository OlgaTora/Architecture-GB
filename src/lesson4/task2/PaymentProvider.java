package lesson4.task2;

public class PaymentProvider {

    public boolean buyTicket(int orderId, String cardNo, double amount){
        // Посылаем запрос на формирование заявки на проведение платежа в процессинговую компанию (ProcessingCompany)

        // Предусловие
        if (amount < 0)
        {
            throw new RuntimeException("Некорректная сумма заказа.");
        }
        if (cardNo.length() != 16)
        {
            throw new RuntimeException("Некорректный номер карты.");
        }
        return true;
    }
}
