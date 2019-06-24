import java.util.ArrayList;
import java.util.List;

public class Trys {
    public static void main(String[] args) {
//        List<Integer> a = new ArrayList<Integer>();
//        for (int i = 0; i<5; i++){
//            a.add(i);
//        }
//        int b = 0;
//        System.out.println(a.get(b++));
//        System.out.println(b);

        List<Integer> list = new ArrayList<>();
        for (int i =0; i<5;i++){
            list.add(i);
        }

        List<ArrayList<Integer>> list2 = new ArrayList<>();
        list2.add(new ArrayList<>(list));

        System.out.println(list);
        System.out.println("-------");
        System.out.println(list2);

    }
}
