//984. 不含 AAA 或 BBB 的字符串
//        给定两个整数 A 和 B，返回任意字符串 S，要求满足：
//
//        S 的长度为 A + B，且正好包含 A 个 'a' 字母与 B 个 'b' 字母；
//        子串 'aaa' 没有出现在 S 中；
//        子串 'bbb' 没有出现在 S 中。
//         
//
//        示例 1：
//
//        输入：A = 1, B = 2
//        输出："abb"
//        解释："abb", "bab" 和 "bba" 都是正确答案。
//        示例 2：
//
//        输入：A = 4, B = 1
//        输出："aabaa"
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/string-without-aaa-or-bbb
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


//使用贪心：如果A大于B ， 就是当时剩下最少的字母是b，一般添加应该添加a，但是要是
//前面两个字母都是aa，那么应该添加b
//总结来说，若前两位相等的话，后面添加的字母不能和前面相同，不然就是谁剩下的多添加谁


package greedy;

public class code984 {
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();

        while (A>0 || B>0){
            int len = sb.length();
            boolean writeA = false;

            if (len>=2 && sb.charAt(len-1) == sb.charAt(len-2)){
                if (sb.charAt(len-1) == 'b'){
                    writeA = true;
                }
            }else {
                if (A>=B){
                    writeA = true;
                }
            }

            if (writeA){
                sb.append('a');
                A--;
            }else {
                sb.append('b');
                B--;
            }
        }

        return sb.toString();
    }
}
