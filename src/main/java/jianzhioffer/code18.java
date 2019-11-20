//二叉搜索树的后序遍历序列
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
// 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

package jianzhioffer;

//思路： 利用二叉搜索树的性质 左节点 《 根节点 《 右节点
public class code18 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0){
            return false;
        }

        if (sequence.length == 1){
            return true;
        }

        return judge(sequence, 0, sequence.length - 1);
    }

    public boolean judge(int[] a, int start, int end){
        if (start >= end){
            return true;
        }

        int j = start;

        while (a[j] < a[end]){
            j++;
        }

        for (int i = j; i< end; i++){
            if (a[i] < a[end]){
                return false;
            }
        }

        return judge(a, start, j - 1) && judge(a, j, end - 1);
    }
}
