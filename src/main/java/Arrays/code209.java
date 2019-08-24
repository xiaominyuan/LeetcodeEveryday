package Arrays;

public class code209 {
    public int minSubArrayLen(int s, int[] nums) {
        //暴力法，超出时间限制

        if (nums == null || nums.length == 0){
            return 0;
        }

        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i<nums.length; i++){
            int sum = 0;
            for (int j = i; j<nums.length; j++){
                sum = sum + nums[j];
                if (sum >= s && j-i+1 < minLen){
                    minLen = j-i+1;
                }
            }
        }

        return minLen;
    }


    //滑动窗口,双指针
    public int minSubArrayLen2(int s, int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        for (int right = 0; right<nums.length; right++){
            sum = sum + nums[right];
            while (sum >= s){
                minLen = Math.min(minLen, right-left+1);
                sum = sum - nums[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

}
