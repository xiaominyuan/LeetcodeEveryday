//面试题20. 表示数值的字符串
//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"及"-1E-16"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
//
// 
//
//注意：本题与主站 65 题相同：https://leetcode-cn.com/problems/valid-number/
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package jianzhier;

public class isNumber20 {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0){
            return false;
        }

        int index = 0;
        int pointCount = 0;
        int numCount = 0;

        if (s.charAt(index) == '-' || s.charAt(index) == '+'){
            index++;
        }

        while (index < s.length() && (s.charAt(index) >= '0' && s.charAt(index) <= '9' || s.charAt(index) == '.')){
            if (s.charAt(index) == '.'){
                pointCount++;
            }else{
                numCount++;
            }

            index++;
        }

        if (pointCount > 1 || numCount < 1){
            return false;
        }

        if (index == s.length()){
            return true;
        }

        if (s.charAt(index) == 'e'){
            index++;

            if (index == s.length()){
                return true;
            }

            if (s.charAt(index) == '-' || s.charAt(index) == '+'){
                index++;
            }

            if (index == s.length()){
                return false;
            }

            while (index < s.length() && (s.charAt(index) >= '0' && s.charAt(index) <= '9')){
                index++;
            }

            if (index == s.length()){
                return true;
            }
        }

        return false;
    }
}
