import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static final Random ran = new Random();
    static Scanner sc = new Scanner(System.in);
    static final Car[] cars = new Car[200];
    static Map<Integer, Journal> journal = new HashMap<>();
    static Parking parking = new Parking();
    static Map<Integer, Payment> check = new HashMap<>();
    static LocalDateTime ldt = LocalDateTime.now();
    static {
        for(int i = 0; i < 200; i++){
            cars[i] = new Car();
        }
    }


    public static void main(String[] args) {
        for(LocalDateTime i = ldt; i.isBefore(ldt.plusDays(30)); i = i.plusMinutes(5)){
            for(Car car:cars){
                if(ran.nextInt(100) + 1 <= 3){
                    car.changeState(parking, car, journal, i);
                }
            }
        }
        createPayment();
        printCheck();


    }
    private static long minutesDifference(LocalDateTime ldt1, LocalDateTime ldt2) {
        return ChronoUnit.MINUTES.between(ldt1, ldt2);
    }
    public static int returnMinutes(Journal journal) {
        LocalTime time1 = LocalTime.of(9, 0);
        LocalTime time2 = LocalTime.of(21, 0);
        int minutes = (int) minutesDifference(journal.getCheckInTime(), journal.getCheckOutTime());
        return minutes;
    }
    public static void createPayment(){
        for(int i = 1; i < journal.size(); i++){
            if(journal.get(i).getCheckOutTime() != null){
                if(returnMinutes(journal.get(i)) >= 30){
                    check.put(check.size() + 1, new Payment(journal.get(i).getCar(), journal.get(i).getCheckInTime(), journal.get(i).getCheckOutTime(), returnMinutes(journal.get(i))));
                }
            }
        }
    }
    public static void printCheck(){
        check.forEach((k, v) -> {
            System.out.printf("%s : %s%n", k, v);
        });
    }







//    public static void drawCanvas(){
//        List<Integer>list = IntStream.range(1,15).boxed().collect(Collectors.toList());
//        Collections.shuffle(list);
//
//        Canvas canvas = new Canvas(45, 18);
//        canvas.drawBorder("#");
//
//        for(int i = 0; i < list.size(); i++) {
//            for (int j = canvas.getHeight() - 1 ; j >= list.get(i); j--) {
//                canvas.setPixel((i + 1) * 3, j - 1, "*");
//            }
//        }
//        System.out.println(canvas.toString());
//
//    }

}