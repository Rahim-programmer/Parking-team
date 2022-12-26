import java.text.Format;
import java.time.LocalDate;
import java.util.Random;

public class Car {
    private String gosnomer = generateGosnomer();
    private LocalDate date;
    private LocalDate time;
private State carState;
    private String generateGosnomer(){
        String nomer = String.format("0%dKG%d%d%dABS", generateNumber(), generateNumber(),generateNumber(),generateNumber());
        return nomer;
    }
    private int generateNumber(){
        Random rnd = new Random();
        return rnd.nextInt(9)+1;
    }

    public State getCarState() {
        return carState;
    }

    public void setCarState(State carState) {
        this.carState = carState;
    }

    public String getGosnomer() {
        return gosnomer;
    }
    public void onRoad() {
        try {
            this.carState.onRoad(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void inParking() {
        try {
            this.carState.inParking(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

