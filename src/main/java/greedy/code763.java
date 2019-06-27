package greedy;

import java.util.ArrayList;
import java.util.List;

public class code763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int startIndex = 0;
        int endIndex = 0;
        char[] arr = S.toCharArray();

        for (int i = 0; i<arr.length; i++){
            int nextIndex = S.indexOf(arr[i], i+1);
            if (nextIndex == -1 && i>=endIndex){
                result.add(i-startIndex+1);
                startIndex = i+1;
            }else {
                if (nextIndex > endIndex){
                    endIndex = nextIndex;
                }
            }
        }
        return result;
    }
}
