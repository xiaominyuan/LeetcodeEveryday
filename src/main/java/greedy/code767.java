//767. 重构字符串
//
//        给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
//
//        若可行，输出任意可行的结果。若不可行，返回空字符串。
//
//        示例 1:
//
//        输入: S = "aab"
//        输出: "aba"
//        示例 2:
//
//        输入: S = "aaab"
//        输出: ""
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/reorganize-string
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


//思路
//首先用一个数组（长度26）维护每个字母对应的出现次数
//然后把这个数组的每个元素放到最大堆中，为了使后续轮流把前两个不同的字母交替放入stringbuilder
//而且放入一次之后，还可以继续把这两个字母用同样的顺序放入最大堆中，同时字母出现的次数都减小1
//堆的作用：在这里堆是维护两个不同字母的相对顺序，交替地插入到stringbuilder中.

package greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class code767 {
    public String reorganizeString(String S) {
        int[] arr = new int[26];

        PriorityQueue<onePrio> pq = new PriorityQueue<>(26, new Comparator<onePrio>(){
            @Override
            public int compare(onePrio p1, onePrio p2){
                return p2.count - p1.count;
            }
        });

        for (int i = 0; i<S.length(); i++){
            arr[S.charAt(i)-'a']++;
        }

        for (int i = 0; i<26; i++){
            if (arr[i]>0 && arr[i] <= (S.length()+1)/2 ){
                pq.add(new onePrio(arr[i], (char) (i+'a')));
            }else if (arr[i]> (S.length()+1)/2){
                return "";
            }
        }


        StringBuilder sb = new StringBuilder();

        while (pq.size()>1){
            onePrio p1 = pq.poll();
            onePrio p2 = pq.poll();

            sb.append(p1.letter);
            sb.append(p2.letter);

            p1.count = p1.count-1;
            p2.count = p2.count-1;


            if (p1.count>0){

                // p1 = new onePrio(p1.count-1,p1.letter);
                pq.add(p1);
                // p1.count = p1.count-1;
            }

            if (p2.count>0){
                // p2 = new onePrio(p2.count-1, p2.letter);
                pq.add(p2);
                // p2.count = p2.count-1;
            }
        }

        if (pq.size()>0){
            onePrio p = pq.poll();
            sb.append(p.letter);
        }

        return sb.toString();



    }

    static class onePrio{
        int count;
        char letter;
        public onePrio(int count, char letter){
            this.count = count;
            this.letter = letter;
        }
    }
}
