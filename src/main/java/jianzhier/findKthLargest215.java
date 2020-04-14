//215. 数组中的第K个最大元素
//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
//示例 1:
//
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
//示例 2:
//
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。






//https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/java-pai-xu-xiao-ding-dui-shi-xian-by-yankuangshig/

package jianzhier;

public class findKthLargest215 {
    public int findKthLargest(int[] nums, int k) {
        buildHeap(nums, k);
        for (int i = k ; i< nums.length; i++){
            if (nums[i] < nums[0]){
                continue;
            }
            swap(nums, i, 0);
            heapify(nums, k, 0);
        }

        return nums[0];
    }

    public void buildHeap(int[] nums, int k){
        for (int i = k/2; i>= 0; i--){
            heapify(nums, k, i);
        }
    }

    public void heapify(int[] nums, int k, int i){
        int minIndex = i;
        while (true){
            if (i*2+1 < k && nums[i*2+1] < nums[i]){
                minIndex = i*2+1;
            }

            if (i*2+2 < k && nums[i*2+2] < nums[minIndex]){
                minIndex = i*2+2;
            }

            if (minIndex == i){
                break;
            }
            swap(nums, i, minIndex);
            i = minIndex;


        }

    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
