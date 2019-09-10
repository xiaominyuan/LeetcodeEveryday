//50. Pow(x, n)
//实现 pow(x, n) ，即计算 x 的 n 次幂函数。
//
//示例 1:
//
//输入: 2.00000, 10
//输出: 1024.00000
//示例 2:
//
//输入: 2.10000, 3
//输出: 9.26100
//示例 3:
//
//输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/powx-n
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



//

package BinarySearch;

public class code50 {
    public double myPow(double x, int n) {
        if (n < 0){
            x = 1/x;
            n = -n;
        }

        return fast(x, n);
    }

    public double fast(double x, int n){
        if (n == 0){
            return 1;
        }

        double half = fast(x, n/2);

        if (n % 2 == 0){
            return half * half;
        }else {
            return half * half * x;
        }
    }
}
