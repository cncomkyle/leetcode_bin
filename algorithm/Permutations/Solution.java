import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    public  void generate(int[] nums, int[] flags, Integer[] prefix, int length, List<List<Integer>> rltList) {
        length++;
        for(int i=0;i<nums.length;i++) {
            if(flags[i] == 1) {
                continue;
            }
            flags[i] = 1;
            prefix[length -1] = nums[i];
            if(length < nums.length) {
                generate(nums, flags, prefix, length, rltList);
            } else {
                Integer[] tmpList = new Integer[length];
                System.arraycopy(prefix, 0, tmpList, 0, length);
                
                rltList.add(Arrays.asList(tmpList));
            }
            flags[i] = 0;
        }

       
        
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rltList = new ArrayList<List<Integer>>();
        if(nums.length==0) {
            return rltList;
        }
        int[] flags = new int[nums.length];
        Integer[] prefix = new Integer[nums.length];
        int length = 0;
        generate(nums, flags, prefix, 0, rltList);
        return rltList;
    }

    public static void main(String[] args) {
        Solution692 ins = new Solution692();
        int[] nums = {1, 2, 3};
        List<List<Integer>> rltList = ins.permute(nums);

        for(List<Integer> tmpList : rltList) {
            for(Integer tmpInt : tmpList) {
                System.out.printf("%d,", tmpInt);
            }
            System.out.println("");
        }
    }
}
