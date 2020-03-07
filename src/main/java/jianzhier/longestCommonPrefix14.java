package jianzhier;

public class longestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }

        String flag = strs[0];

        for (int i = 1; i< strs.length; i++){
//            int index = 0;
            int j =0;
            for (; j < flag.length() && j < strs[i].length(); j++){
                if (strs[i].charAt(j) != flag.charAt(j)){
                    break;
                }
            }
            flag = flag.substring(0, j);
            if (flag.equals("")){
                return "";
            }
        }

        return flag;
    }
}
