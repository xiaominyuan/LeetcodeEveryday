//735. 行星碰撞
//给定一个整数数组 asteroids，表示在同一行的行星。
//
//对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
//
//找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
//
//示例 1:
//
//输入:
//asteroids = [5, 10, -5]
//输出: [5, 10]
//解释:
//10 和 -5 碰撞后只剩下 10。 5 和 10 永远不会发生碰撞。
//示例 2:
//
//输入:
//asteroids = [8, -8]
//输出: []
//解释:
//8 和 -8 碰撞后，两者都发生爆炸。
//示例 3:
//
//输入:
//asteroids = [10, 2, -5]
//输出: [10]
//解释:
//2 和 -5 发生碰撞后剩下 -5。10 和 -5 发生碰撞后剩下 10。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/asteroid-collision
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package Stack;

import java.util.Stack;

//第一种：序列本身就是空，此时不会产生碰撞，直接放入行星序列的尾端。
//第二种：当序列的最尾端是负数，nextItem < 0，这时方向相同并且速度相同，两个同方向的行星不会产生碰撞，直接放入行星序列的尾端。
//第三种：当序列的最尾端是负数，nextItem > 0，这时两个行星的运动方向相反，并不会产生碰撞（比如[-5,-10]在右端放入5），直接放入行星序列的尾端。
//第四种：当序列的最尾端是正数，nextItem > 0，这时方向相同并且速度相同，两个同方向的行星不会产生碰撞，直接放入行星序列的尾端。
//第五种：当序列的最尾端是正数，nextItem < 0，这时方向相对，两个方向的行星必定会产生碰撞，按照碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。
//也就是说，只有第五种情况需要特殊处理。


public class code735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int num : asteroids){
            if (stack.empty()){
                stack.push(num);
                continue;
            }else if (stack.peek() > 0 && num < 0){
                while (!stack.empty() && stack.peek() > 0 && num < 0){
                    int sum = stack.peek() + num;

                    //栈顶比较小
                    if (sum > 0){
                        stack.pop();
                    }else if (sum == 0){
                        //一样大
                        stack.pop();
                        num = Integer.MAX_VALUE;
                        break;
                    }else {
                        //栈顶比较大
                        num = Integer.MAX_VALUE;
                        break;
                    }
                }

                if (num != Integer.MAX_VALUE){
                    stack.push(num);
                }
            }else {
                stack.push(num);
            }
        }

        int[] res = new int[stack.size()];
        for (int i = stack.size(); i>0; i--){
            res[i-1] = stack.pop();
        }

        return res;
    }
}
