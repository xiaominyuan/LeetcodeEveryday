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
