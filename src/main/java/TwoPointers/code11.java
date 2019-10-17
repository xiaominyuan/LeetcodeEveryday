//11. 盛最多水的容器
//给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
//说明：你不能倾斜容器，且 n 的值至少为 2。
//
//
//
//图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
// 
//
//示例:
//
//输入: [1,8,6,2,5,4,8,3,7]
//输出: 49
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/container-with-most-water
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package TwoPointers;

public class code11 {
    //暴力搜索面积
    public int maxArea(int[] height) {
        int res = 0;
        for (int i = 0; i<height.length-1; i++){
            for (int j = i+1; j<height.length; j++){
                res = Math.max(Math.min(height[j], height[i])*(j-i), res);
            }
        }

        return res;
    }
    //双指针，短的线段的指针往长的线段移动
    public int maxArea2(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right){
            res = Math.max(Math.min(height[left], height[right])*(right-left), res);
            if (height[left] <= height[right]){
                left++;
            }else {
                right--;
            }
        }

        return res;
    }
}
