import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();

        Arrays.sort(nums);
        int p1, p2, tmp, tmp1;
        for(int i=0;i<nums.length - 2; i++) {
            tmp1 = -1 * nums[i];
            p1 = i + 1;
            p2 = nums.length - 1;

            while(p1 < p2) {
                tmp = nums[p1] + nums[p2];
                if(tmp == tmp1) {
                    resultList.add(Arrays.asList(nums[i], nums[p1], nums[p2]));

                    while(p1 < p2
                          && nums[p1+1]==nums[p1]) {
                        p1++;
                    }
                    p1++;

                    while(p1 < p2
                          && nums[p2 - 1]==nums[p2]) {
                        p2--;
                    }
                    p2--;
                    
                } else if (tmp < tmp1) {
                    p1++;
                } else {
                    p2--;
                }
            }

            while(i < nums.length - 2
                  && nums[i+1] == nums[i]) {
                i++;
            }
            
        }
        
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        Solution ins = new Solution();
        List<List<Integer>> result = ins.threeSum(nums);
        for(List<Integer> tmpList : result) {
            for(Integer tmp : tmpList) {
                System.out.printf("%d ", tmp);
            }
            System.out.println("");
        }
    }
}
