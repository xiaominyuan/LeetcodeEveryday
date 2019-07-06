//60. 第k个排列
//待解决
package backTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class code60 {
    public String getPermutation(int n, int k) {
        List<List<Integer>> result = new ArrayList();
        ArrayList<Integer> tmp = new ArrayList<Integer>();

        int[] nums = new int[n];

        for (int i = 0; i<n; i++){
            nums[i]=i+1;
            tmp.add(i+1);
        }

        backTracking(n, 0, tmp, result);

//         List<Integer> sub = result.get(k-1);

//         String res = "";

//         for (int i : sub){
//             res = res +String.valueOf(i);
//         }

        List<Integer> subList = new ArrayList<>();

        for (List<Integer> li : result){
            String tmpStr = "";
            for (int i : li){
                tmpStr = tmpStr + String.valueOf(i);
            }
            subList.add(Integer.parseInt(tmpStr));
        }

        Collections.sort(subList);

        return String.valueOf(subList.get(k-1));


    }

    public void backTracking(int n, int start, ArrayList<Integer> tmp, List<List<Integer>> result){
        if (start == n){
            result.add(new ArrayList(tmp));
        }

        for (int i = start; i<n; i++){
            Collections.swap(tmp, i ,start);
            backTracking(n, start+1, tmp, result);
            Collections.swap(tmp, i, start);
        }
    }
}
