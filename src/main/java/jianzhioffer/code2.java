//替换空格
//请实现一个函数，将一个字符串中的每个空格替换成“%20”。
// 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

package jianzhioffer;

public class code2 {
    public String replaceSpace(StringBuffer str) {
        StringBuffer res = new StringBuffer();

        for (int i = 0; i< str.toString().length(); i++){
            char ch = str.charAt(i);
            if (String.valueOf(ch).equals(" ")){
                res.append("%20");
            }else {
                res.append(String.valueOf(ch));
            }
        }

        return res.toString();
    }
}
