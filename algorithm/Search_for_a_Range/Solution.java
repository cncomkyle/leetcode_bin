class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = -1;
        int[] result = new int[2];
        int start = -1, end = -1;
        while(left <= right) {
            mid = left + (right + 1 - left) / 2;
            if(nums[mid] == target) {
                start = end = mid;
                
                while(start>0) {

                    if(start >=1 
                       && nums[start-1]!=target) {
                        break;
                    }
                    start--;
                }
                
                while(end < nums.length - 1) {
                    if(end < nums.length - 1
                       && nums[end+1]!=target) {
                        break;
                    }
                    end++;
                }
                
                break;
            }

            if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        result[0] = start;
        result[1] = end;
        return result;
    }

    public static void main(String[] args) {
        Solution ins = new Solution();
        int[] nums = {5, 7, 7, 8, 8, 8, 10};
        int[] rlt = ins.searchRange(nums, 8);
        rlt = ins.searchRange(nums, 6);
        nums = new int[]{1};
        rlt = ins.searchRange(nums, 1);
        for(int i : rlt) {
            System.out.println(i);
        }
    }
}
