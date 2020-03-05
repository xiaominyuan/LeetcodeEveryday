//面试题11. 旋转数组的最小数字


package jianzhier;

public class minArray11 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length-1;
        while (left < right){
            int mid = (left + right)/2;
            if (numbers[mid] < numbers[right]){
                right = mid;
            }else if (numbers[mid] > numbers[right]){
                left = mid + 1;
            }else{
                right = right - 1;
            }
        }

        return numbers[right];
    }
}
