2 : 0
7 : 1
11 : 2
15 :3
-16:4    
    
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++) {
            if(nums[i]>target) {
                continue;
            }
            for(int j=i+1;j<nums.length;j++) {
                if(nums[j]>target) {
                    continue;
                }
                if(nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = {-3, 4, 3, 90};
        int target = 0;
        Solution instance = new Solution();
        int[] rlt= instance.twoSum(data, target);
        for(int tmp : rlt) {
            System.out.println(tmp);
        }
    }
}
