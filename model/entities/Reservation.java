package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime();             // diferença entre as duas datas em milissegundos
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);      // converte milissegundos para dias
    }

    public String updateDates(Date checkIn, Date checkOut) {

        /*
         * ao debuggar, vi que a data devolvida está em JANEIRO
         * checkIn: "Sat Jan 22 00:08:00 COT 2022"
         * checkOut: "Mon Jan 24 00:08:00 COT 2022"
         */
        Date now = new Date();

        // se a data de checkIn for antes de agora OU checkOut for antes de AGORA
        if (checkIn.before(now) || checkOut.before(now)) {
            return "Erro na reserva: a data de reserva deve ser futura.";
        }
        // se a data de checkOut for antes
        if (checkOut.before(checkIn)) {
            return "Erro na reserva: data de chek-out deve ser posterior ao check-in";
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
    }

    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + ", check in date: "
                + sdf.format(checkIn) + "\n"
                + "Check out date: "
                + sdf.format(checkOut)
                + ", " + duration() + " nights";
    }
}
