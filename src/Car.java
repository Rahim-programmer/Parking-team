import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;

public class Car {
    private String carNumber ;

    private State carState;

    private String generateCarNumber() {
        String number = String.format("0%dKG%d%d%dABS", generateNumber(), generateNumber(), generateNumber(), generateNumber());
        return number;
    }

    private int generateNumber() {
        Random rnd = new Random();
        return rnd.nextInt(9) + 1;
    }

    public State getCarState() {
        return carState;
    }

    public void setCarState(State carState) {
        this.carState = carState;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public Car() {
        this.carNumber = generateCarNumber();
        carState = State.ON_WAY;
    }

    @Override
    public String toString() {
        return carNumber;
    }

    public void changeState(Parking parking, Car car, Map<Integer, Journal> journal, LocalDateTime time) {
        try {
            carState.changeState(parking, car, journal, time);
        } catch (Exception e) {
            System.out.print("");
        }
    }
}

