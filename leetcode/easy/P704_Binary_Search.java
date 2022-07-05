public class P704_Binary_Search {

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        int start = 0;
        int end = nums.length - 1;

        int result = -1;

        while(end >= start) {
            int mi = (end+start) / 2;
            int median = nums[mi];

            if(median > target) {
                end = mi - 1;
            }
            else if(median < target) {
                start = mi + 1;
            } else {
                result = mi;
                break;
            }
        }

        return result;
    }
}