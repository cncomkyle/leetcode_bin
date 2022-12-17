import java.util.Map;
import java.util.HashMap;

public class Solution {
    public int majorityElement_old(int[] nums) {
        if(nums.length == 0) {
            return -1;
        }

        if(nums.length <= 2) {
            return nums[0];
        }

        int target = (int)Math.ceil(nums.length / 2.0);
        Map<Integer, Integer> numMap = new HashMap<>();
        int tmpMax = 0;

        for(int tmpNum : nums) {
            Integer tmpCnt = numMap.get(tmpNum);
            if(tmpCnt == null) {
                tmpCnt = 1;
            } else {
                tmpCnt = tmpCnt + 1;
            }
            numMap.put(tmpNum, tmpCnt);
            tmpMax = Math.max(tmpMax, tmpCnt);

            if(tmpMax == target) {
                return tmpNum;
            }
        }

        return nums[0];
    }

    public int majorityElement(int[] nums) {

        int candidate = nums[0];
        int cnt = 1;

        for(int i=1;i<nums.length;i++) {
            if(cnt == 0) {
                candidate = nums[i];
            }

            cnt += (candidate == nums[i])?1:-1;
        }
        
        return candidate;
    }
        

    public static void main(String[] args) {
        Solution ins = new Solution();

        System.out.println(ins.majorityElement(new int[]{3, 2, 3}));
        System.out.println(ins.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
