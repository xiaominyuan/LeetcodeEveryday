//面试题33. 二叉搜索树的后序遍历序列
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
//
// 
//
//参考以下这颗二叉搜索树：
//
//     5
//    / \
//   2   6
//  / \
// 1   3
//示例 1：
//
//输入: [1,6,3,2,5]
//输出: false
//示例 2：
//
//输入: [1,3,2,6,5]
//输出: true
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package jianzhier;

public class verifyPostorder33 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length < 2){
            return true;
        }

        return judge(postorder, 0, postorder.length-1);


    }

    public boolean judge(int[] postorder, int left, int right){
        if (left >= right){
            return true;
        }

        int i;

        for (i = left; i< right; i++){
            if (postorder[i] > postorder[right]){
                break;
            }
        }

        for (int j = i; j< right; j++){
            if (postorder[j] < postorder[right]){
                return false;
            }
        }

        return judge(postorder, left, i-1) && judge(postorder, i, right-1);
    }
}
