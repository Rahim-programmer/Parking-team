import java.text.Format;
import java.util.Random;

public class Car {
    private String gosnomer = generateGosnomer();

    private String generateGosnomer(){
        String nomer = String.format("0%dKG%d%d%dABS", generateNumber(), generateNumber(),generateNumber(),generateNumber());
        return nomer;
    }
    private int generateNumber(){
        Random rnd = new Random();
        return rnd.nextInt(9)+1;
    }

    public String getGosnomer() {
        return gosnomer;
    }
}

