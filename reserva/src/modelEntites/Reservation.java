package modelEntites;

import modelEx.DomainEx;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer quartoNm;
    private Date checkIn;
    private Date checkOut;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer quartoNm, Date checkIn, Date checkOut) throws DomainEx {
        if (!checkOut.after(checkIn)) {
            throw new DomainEx("Check-out date must be after check-in date");
        }

        this.quartoNm = quartoNm;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getQuartoNm() {
        return quartoNm;
    }

    public void setQuartoNm(Integer quartoNm) {
        this.quartoNm = quartoNm;
    }

    public Date getCheckIn() {
        return checkIn;
    }


    public Date getCheckOut() {
        return checkOut;
    }

    public Long duration(){
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut) throws DomainEx{
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            throw new DomainEx("Reservation dates for update must be future dates");
        }
        if (!checkOut.after(checkIn)) {

            throw new DomainEx("Check-out date must be after check-in date");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString(){
        return "Quarto " + quartoNm +
                ", checkIn: "+ sdf.format(checkIn)+
                ", checkOut: " + sdf.format(checkOut)+
                ", " + duration()+
                " noites";

    }

}
