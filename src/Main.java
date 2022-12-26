import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    Car car = new Car();
    static Parking parking = new Parking();
    private static final List<Boolean> parkingPlaces = parking.getPlacePark();
    private static final Set<Car> cars = new HashSet<>();
    public static void main(String[] args) {


        Map<String, Car> cars = new HashMap<>();
        String[] numsData = new String[200];
        for (int i = 0; i < 200; i++) {
            Car car = new Car();
            cars.put(car.getGosnomer(), car);
            numsData[i] = car.getGosnomer();
            System.out.println(car.getGosnomer());


        }




    }
    public static void drawCanvas(){
        List<Integer>list = IntStream.range(1,15).boxed().collect(Collectors.toList());
        Collections.shuffle(list);

        Canvas canvas = new Canvas(45, 18);
        canvas.drawBorder("#");

        for(int i = 0; i < list.size(); i++) {
            for (int j = canvas.getHeight() - 1 ; j >= list.get(i); j--) {
                canvas.setPixel((i + 1) * 3, j - 1, "*");
            }
        }
        System.out.println(canvas.toString());

    }
//    public static String generateKey(){
//
//    }
}