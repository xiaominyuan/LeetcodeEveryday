//668. 乘法表中第k小的数
//几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？
//
//给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
//
//例 1：
//
//输入: m = 3, n = 3, k = 5
//输出: 3
//解释:
//乘法表:
//1	2	3
//2	4	6
//3	6	9
//
//第5小的数字是 3 (1, 2, 2, 3, 3).
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/kth-smallest-number-in-multiplication-table
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package jianzhier;

public class findKthNumber668 {
    public int findKthNumber(int m, int n, int k) {
        if (k == 1){
            return 1;
        }

        if (m*n == k){
            return m*n;
        }

        int left = 1;
        int right = m*n;

        while (left < right){
            int mid = (left + right)/2;
            int count = find(m, n, mid);

            if (count >= k){
                right = mid;
            }else{
                left = mid +1;
            }
        }

        return left;
    }

    public int find(int m, int n, int target){
        int count = 0;
        for (int i = 1; i <= m; i++){
            count = count + Math.min(target/i, n);
        }

        return count;
    }
}
