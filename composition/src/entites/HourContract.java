package entites;

import java.util.Date;

public class HourContract {
    private Date data ;
    private double valuePerHour;
    private Integer hour;

    public HourContract(){
    }
    public HourContract(Date data, double valuePerHour, Integer hour) {
        this.data = data;
        this.valuePerHour = valuePerHour;
        this.hour = hour;
    }

    public double totalValue(){
        return valuePerHour * hour;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }
}
