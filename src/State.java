public enum State {
    ON_PARKING("на парковке") {
        @Override
        public void onRoad(Car car) throws Exception {
            Parking parking = new Parking();
            car.setCarState(State.ON_WAY);
            System.out.println("Машина выехала со стоянки");
            parking.getPlacePark().add(false);
        }

        @Override
        public void inParking(Car car) throws Exception {
            throw new Exception("Машина  на стоянке.");
        }


    },

    ON_WAY("в пути") {
        @Override
        public void onRoad(Car car) throws Exception {
            throw new Exception("Машина в пути");
        }

        @Override
        public void inParking(Car car) throws Exception {
            Parking parking = new Parking();
            car.setCarState(State.ON_PARKING);
            System.out.println("Машина прибыла на стоянку");
            parking.getPlacePark().add(true);
        }
    };

    private String value;

    public String getValue() {
        return value;
    }

    State(String value) {
        this.value = value;
    }

    public abstract void onRoad(Car car) throws Exception;

    public abstract void inParking(Car car) throws Exception;
}
