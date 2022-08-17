package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

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

    public void updateDates(Date checkIn, Date checkOut) {
        // TODO: implementar a logica de atualizacao de datas
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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
