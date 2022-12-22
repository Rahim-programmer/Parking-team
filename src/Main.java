import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("777");
        Car car = new Car();
        System.out.println(car.getGosnomer());
        Parking parking = new Parking();
        parking.setCar(car);
        System.out.println(parking.getCar().toString());
    }
}