package lesson4.task2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

class Ticket {
    //region Constructor
    public Ticket(int customerId, TicketType ticketType) {
        this.customerId = customerId;
        this.ticketType = ticketType;
        this.qrcode = generateQrcode();
    }

    //endregion
    //region Properties
    private String generateQrcode() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String qrcode = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return qrcode;
    }


    public int getId() {
        return id;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getQrcode() {
        return qrcode;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(date);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", date=" + date +
                ", qrcode='" + qrcode + '\'' +
                ", ticketType=" + ticketType +
                ", enable=" + enable +
                '}' + '\n';
    }

    //endregion
    //region Fields
    private static int counter;
    private final int id;
    private final int customerId;
    private final Date date = new Date();
    private final String qrcode;
    private final TicketType ticketType;

    {
        id = ++counter;
    }

    private boolean enable = true;
    //endregion
}
