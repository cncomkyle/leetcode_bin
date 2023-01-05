class Solution {

    
    public int search(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        int mid = -1;
        while(left <= right) {
            mid = left + (right + 1 - left) / 2;
            System.out.printf("left:%d right:%d mid:%d\n", left, right, mid);
            
            if(nums[mid] == target) {
                return mid;
            }

            if(nums[mid] >= nums[left]) {
                if(nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[right])  {
                    left = mid + 1;
                } else {
                    right = right -1;
                }
            }

            
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution692 ins = new Solution692();
        int[] nums = {4, 5, 6, 7 , 0, 1, 2};
        System.out.println(ins.search(nums, 4));
        System.out.println(ins.search(nums, 3));
        System.out.println(ins.search(nums, 0));
        nums = new int[]{3, 1};
        System.out.println(ins.search(nums, 3));
        nums = new int[]{1, 3};
        System.out.println(ins.search(nums, 1));
        nums = new int[]{5, 1, 3};
        System.out.println(ins.search(nums, 5));
        nums = new int[]{7,8,1,2,3,4,5,6};
        System.out.println(ins.search(nums, 2));
    }
}
