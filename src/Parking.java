import java.util.HashMap;
import java.util.Map;

public class Parking {
    private int capacity = 20;
    private int takenSpaces;
    private int availableSpaces = capacity-takenSpaces;
    private double price = 0.1;
    private Map<String, Car>car;

    public void setCar(Car carData) {
        Map<String, Car> car = new HashMap<>();
        car.put(carData.getGosnomer(), carData);
        this.car = car;
    }

    public Map<String, Car> getCar() {
        return car;
    }
}
