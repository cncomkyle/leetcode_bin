class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) {
            return 0;
        }
        int result = 0;
        int left = 0, right = nums.length - 1;

        if(target < nums[left]) {
            return 0;
        }

        if(target > nums[right]) {
            return right + 1;
        }

        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid]==target) {
                return mid;
            } else if(nums[mid] < target) {
                if(target < nums[mid+1]) {
                    return mid + 1;
                }
                left = mid + 1;
            } else {
                if(target > nums[mid -1]) {
                    return mid;
                }
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution ins = new Solution();
        int[] nums = {1, 3, 5, 6};
        System.out.println(ins.searchInsert(nums, 5));
        System.out.println(ins.searchInsert(nums, 2));
        System.out.println(ins.searchInsert(nums, 7));
        System.out.println(ins.searchInsert(nums, 0));

        nums = new int[]{1, 3};
        System.out.println(ins.searchInsert(nums, 2));
    }
}
