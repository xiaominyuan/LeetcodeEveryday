//面试题16. 数值的整数次方
//实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
//
// 
//
//示例 1:
//
//输入: 2.00000, 10
//输出: 1024.00000
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
package backTracking;

public class myPow16 {
    public double myPow(double x, int n) {
        long a = n;
        if (n < 0){
            return 1/help(x, -n);
        }else{
            return help(x, n);
        }
    }

    public double help(double x, long n){
        if (n == 0){
            return 1;
        }

        if (x == 1){
            return 1;
        }

        if (n % 2 == 0){
            double res = help(x, n/2);
            return res*res;
        }else{
            double res = help(x, (n-1)/2);
            return res*res*x;
        }
    }
}
