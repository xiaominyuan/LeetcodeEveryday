//面试题 10.01. 合并排序的数组
//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
//
//初始化 A 和 B 的元素数量分别为 m 和 n。
//
//示例:
//
//输入:
//A = [1,2,3,0,0,0], m = 3
//B = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/sorted-merge-lcci
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package jianzhier;

public class merge10 {
    public void merge(int[] A, int m, int[] B, int n) {
        int i = 0;
        int j = 0;
        int cur = 0;
        int[] result = new int[m+n];

        while (i < m && j < n){
            if (A[i] <= B[j]){
                result[cur] = A[i];
                cur++;
                i++;
            }else{
                result[cur] = B[j];
                cur++;
                j++;
            }
        }
        while (i < m){
            result[cur] = A[i];
            cur++;
            i++;
        }

        while (j < n){
            result[cur] = B[j];
            cur++;
            j++;
        }

        for (int x = 0; x < m+n; x++){
            A[x] = result[x];
        }
    }
}
