//151. 翻转字符串里的单词
//给定一个字符串，逐个翻转字符串中的每个单词。
//
// 
//
//示例 1：
//
//输入: "the sky is blue"
//输出: "blue is sky the"
//示例 2：
//
//输入: "  hello world!  "
//输出: "world! hello"
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
//示例 3：
//
//输入: "a good   example"
//输出: "example good a"
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package strings;

import java.util.Arrays;
import java.util.Collections;

public class code151 {

    //方法1 调用库
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }


    //方法2 先反转字符串，在单独反转单词， 在去除空格
    public String reverseWords2(String s) {
        if (s == null){
            return null;
        }

        char[] arr = s.toCharArray();
        int len = arr.length;

        reverse(arr, 0, len-1);

        reverseWord(arr, len);

        return cleanWord(arr, len);

    }

    public void reverse(char[] arr, int low, int high){
        while (low < high){
            char tmp = arr[low];
            arr[low] = arr[high];
            arr[high] = tmp;
            low++;
            high--;
        }
    }

    public void reverseWord(char[] arr, int len){
        int i = 0;
        int j = 0;
        while (j < len){
            while (i < len && arr[i] == ' '){
                i++;
            }
            j = i;
            while (j < len && arr[j] != ' '){
                j++;
            }

            reverse(arr,i , j-1);
            i = j;
        }
    }

    public String cleanWord(char[] arr, int len){
        int i = 0;
        int j = 0;
        while (j < len){
            while (j < len && arr[j] == ' '){
                j++;
            }

            while (j < len && arr[j] != ' '){
                arr[i++] = arr[j++];
            }

            while (j < len && arr[j] == ' '){
                j++;
            }

            if (j < len){
                arr[i++] = ' ';
            }
        }

        return new String(arr).substring(0, i);
    }
}
