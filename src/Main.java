import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
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
}