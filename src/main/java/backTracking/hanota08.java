//面试题 08.06. 汉诺塔问题
package backTracking;

import java.util.List;

public class hanota08 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        help(A.size(), A,B,C);
    }

    public void help(int n , List<Integer> A, List<Integer> B, List<Integer> C){
        if (n == 1){
            move(A,C);
        }else{
            help(n-1, A, C, B);
            move(A,C);
            help(n-1, B,A,C);
        }
    }

    public void move(List<Integer> A, List<Integer> C){
        C.add(A.remove(A.size()-1));
    }
}
