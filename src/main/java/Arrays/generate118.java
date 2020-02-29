//118. 杨辉三角
/**
 *  1
 *  1 1
 *  1 2 1
 *  1 3 3 1
 *  1 4 6 4 1
 *  1 5 10 10 5 1
 * @param numRows
 * @return
 */

package Arrays;

import java.util.ArrayList;
import java.util.List;

public class generate118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        int[][] arr = new int[numRows][numRows];

        for (int i = 0; i< numRows; i++){
            List<Integer> tmp = new ArrayList<>();

            for (int j = 0; j <= i; j++){
                if (j == 0 || j== i){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
                tmp.add(arr[i][j]);
            }
            result.add(tmp);
        }

        return result;
    }
}
