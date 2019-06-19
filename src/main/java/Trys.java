import java.util.ArrayList;
import java.util.List;

public class Trys {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i<5; i++){
            a.add(i);
        }
        int b = 0;
        System.out.println(a.get(b++));
        System.out.println(b);
    }
}
