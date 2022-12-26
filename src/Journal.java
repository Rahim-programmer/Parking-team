import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Journal {
    private Car car;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;

    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public Journal(Car car, LocalDateTime checkInTime) {
        this.car = car;
        this.checkInTime = checkInTime;
    }

    @Override
    public String toString() {
        return  car + " Заехал: " + formatter.format(checkInTime) +
                ", Выехал: " + ((checkOutTime != null ? formatter.format(checkInTime) : checkOutTime));
    }
}
