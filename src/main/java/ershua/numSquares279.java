package ershua;

import java.util.LinkedList;
import java.util.Queue;

public class numSquares279 {

    //方法2 bfs
    //https://leetcode-cn.com/problems/perfect-squares/solution/yan-du-you-xian-sou-suo-java-by-1874-14/
    public class Node{
        public int val;
        public int level;
        public Node(){};
        public Node(int val, int level){
            this.val = val;
            this.level = level;
        }
    }

    //方法一
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i<=n; i++){
            dp[i] = i;
            for (int j = 1; i-j*j>=0; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }

        return dp[n];
    }

    public int numSquares2(int n){
        Queue<Node> queue = new LinkedList<>();
        boolean[] record = new boolean[n];
        queue.add(new Node(n, 1));

        while (!queue.isEmpty()){
            Node tmp = queue.poll();

            for (int i =1; i<= n; i++){
                int num = tmp.val - i*i;
                if (num < 0){
                    break;
                }

                if (num == 0){
                    return tmp.level;
                }

                if (record[num] == false){
                    queue.add(new Node(num, tmp.level+1));
                    record[num] = true;
                }
            }
        }

        return -1;
    }
}
