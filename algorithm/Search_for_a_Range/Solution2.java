class Solution2 {
    public int getEdgePoint(int[] nums, int target, boolean leftFlag) {
        if(nums.length == 0) {
            return -1;
        }

        int left=0, right=nums.length - 1, mid;
        
        while(left <= right) {
            mid = left + (right + 1 - left) /2;
            System.out.printf("left:%d, right:%d, mid:%d\n", left, right, mid);
            // mid = (left + right) /2;
            if(nums[mid] > target || (leftFlag && nums[mid] == target)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int start =-1;

        start = getEdgePoint(nums, target, true);
        // System.out.println(start);
        if(start < 0
           || start == nums.length
           || (nums[start] != target)) {
            return result;
        }
        
        result[0] = start;
        result[1] = getEdgePoint(nums, target, false) - 1;

        return result;
    }

    public static void main(String[] args) {
        Solution2 ins = new Solution2();
        int[] nums = {5, 7, 7, 8, 8, 8, 10};
        int[] rlt = ins.searchRange(nums, 8);
        // rlt = ins.searchRange(nums, 6);
        // nums = new int[]{1};
        // rlt = ins.searchRange(nums, 1);

        // nums = new int[]{};
        // rlt = ins.searchRange(nums, 0);
        for(int i : rlt) {
            System.out.println(i);
        }
    }
            
}
