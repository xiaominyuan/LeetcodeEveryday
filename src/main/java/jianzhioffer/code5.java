//旋转数组的最小数字
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
//输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
//例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
//NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。


package jianzhioffer;

public class code5 {
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0){
            return 0;
        }

        if (array.length == 1){
            return array[0];
        }

        int left = 0;
        int right = array.length - 1;

        if (array[right] >= array[left]){
            return array[left];
        }


        while (left <= right){
            int mid = left + (right - left)/2;

            if (array[mid+1] < array[mid]){
                return array[mid+1];
            }

            if (array[mid] < array[mid-1]){
                return array[mid];
            }

            if (array[mid] < array[right]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return -1;
    }

}
