import java.time.LocalDateTime;
import java.util.Map;

public enum State {
    IN_PARKING("На парковке"){
        @Override
        public void changeState(Parking parking, Car car, Map<Integer, Journal> journal, LocalDateTime time) throws Exception {
            car.setCarState(State.ON_WAY);
            parking.upParkingCapacity();
            parking.removeCar(car);
            for(int i = journal.size(); i > 0; i--){
                if(journal.get(i).getCar().equals(car)){
                    journal.get(i).setCheckOutTime(time);
                    break;
                }
            }

        }
    },
    ON_WAY("В пути"){
        @Override
        public void changeState(Parking parking, Car car, Map<Integer, Journal> journal, LocalDateTime time) throws Exception {
            if(parking.getParkingCapacity() > 0){
                car.setCarState(State.IN_PARKING);
                parking.dawnParkingCapacity();
                parking.addCar(car);
                journal.put(journal.size() + 1, new Journal(car, time));
            }else {
                throw new Exception("Парковка заполнена!");
            }
        }
    };


    private String value;

    State(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public abstract void changeState(Parking parking, Car car, Map<Integer, Journal> journal, LocalDateTime i) throws Exception;
}
