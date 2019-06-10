//647. 回文子串
//
//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
//
//具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串
//
//        输入: "abc"
//        输出: 3
//        解释: 三个回文子串: "a", "b", "c".


public class code647 {
    public int countSubstrings(String s) {

        char[] arr = s.toCharArray();

        int counts = 0;

        boolean[][] dp = new boolean[arr.length][arr.length];

        for (int i = 1; i<arr.length+1; i++){
            for (int j = 0; j<arr.length-i+1; j++){
                if (i == 1){
                    dp[j][j] = true;
                    counts++;
                }else if (i ==2){
                    if (arr[j] == arr[j+1]){
                        dp[j][j+1] = true;
                        counts++;
                    }
                }else {
                    if (arr[j] == arr[j+i-1] && dp[j+1][j+i-2] == true){
                        dp[j][j+i-1] = true;
                        counts++;
                    }
                }
            }
        }

        return counts;
    }
}
