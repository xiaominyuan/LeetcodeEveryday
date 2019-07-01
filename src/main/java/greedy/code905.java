//905. 按奇偶排序数组
//        给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
//
//        你可以返回满足此条件的任何数组作为答案。
//
//         
//
//        示例：
//
//        输入：[3,1,2,4]
//        输出：[2,4,3,1]
//        输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/sort-array-by-parity
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package greedy;

public class code905 {
    public int[] sortArrayByParity(int[] A) {
        //偶数往左边放，奇数往右边放
//         int[] a = new int[A.length];
//         int start = 0;
//         int end = A.length-1;
//         for (int i = 0; i<A.length; i++){
//             if (A[i]%2 == 0){
//                 a[start] = A[i];
//                 start++;
//             }else{
//                 a[end] = A[i];
//                 end--;
//             }
//         }

//         return a;



        //双指针
        //左偶右奇数，不用交换，直接两个指针向中间移动
        //左奇数右奇数，右边的数不用动，右指针向左移动，希望下次交换把左奇数交换过来
        //左偶数右偶数, 左边的数不用动，左指针向右移动，希望下次把右偶数交换过来
        //左奇数右偶数，两个数直接原地交换，并且两个指针同时向中间移动

        int start = 0;
        int end = A.length-1;
        while (start < end){
            if (A[start]%2 == 1 && A[end]%2 == 0){
                int tmp = A[start];
                A[start] = A[end];
                A[end] = tmp;
                start++;
                end--;
            }else if(A[start]%2 == 0 && A[end]%2 == 0){
                start++;
            }else if (A[start]%2 == 1 && A[end]%2 == 1){
                end--;

            }else{
                start++;
                end--;
            }
        }
        return A;
    }
}
