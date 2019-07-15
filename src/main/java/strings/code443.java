//443. 压缩字符串
//        给定一组字符，使用原地算法将其压缩。
//
//        压缩后的长度必须始终小于或等于原数组长度。
//
//        数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
//
//        在完成原地修改输入数组后，返回数组的新长度。
//
//         
//
//        进阶：
//        你能否仅使用O(1) 空间解决问题？
//
//         
//
//        示例 1：
//
//        输入：
//        ["a","a","b","b","c","c","c"]
//
//        输出：
//        返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
//
//        说明：
//        "aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/string-compression
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package strings;

public class code443 {
    public int compress(char[] chars) {
        int len = chars.length;
        //指针记录
        int tmp =0;
        for (int i=0, j=0; i<len; i=j){
            while (j<len && chars[j]==chars[i]){
                j++;
            }


            //记录每段字符串的首位,如【a,a,a】记录[a]
            chars[tmp] = chars[i];
            tmp=tmp+1;

            //如果只有一个值，没有重复，直接跳过循环，因为没有【a,1】这种表示
            if (j-i == 1){
                continue;
            }

            for (char a : String.valueOf(j-i).toCharArray()){
                chars[tmp] = a;
                tmp=tmp+1;
            }
        }
        return tmp;
    }
}
