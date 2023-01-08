import java.util.*;

public class Solution {


    public List<List<Integer>> threeSum_old(int[] nums) {
        Arrays.sort(nums);
             
        List<List<Integer>> rltList = new ArrayList<>();
        for(int i=0;i<nums.length - 2;i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            boolean breakFlg = false;
            for(int j=i+2;j<nums.length;j++) {
                if(breakFlg) {
                    break;
                }
                if(j>i+2 && nums[j]==0) {
                    break;
                }
                for(int k=i+1;k<j;k++) {
                    if(nums[i] + nums[k] + nums[j] > 0) {
                        break;
                    }
                    if(k>i+1 && nums[k] == nums[k-1]) {
                        continue;
                    }
                    if(nums[i] + nums[k] + nums[j] == 0) {
                        List<Integer> newList = new ArrayList<>();
                        newList.add(nums[i]);
                        newList.add(nums[k]);
                        newList.add(nums[j]);

                        rltList.add(newList);
                        breakFlg = true;
                        break;
                    }
                }
            }
        }

        return rltList;
    }


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
             
        List<List<Integer>> rltList = new ArrayList<>();
        
        for(int i=0;i<nums.length - 2;i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int right = nums.length - 1;
            for(int j=i+1;j<nums.length-1;j++) {
                if(j>i+1 && nums[j] == nums[j-1]) {
                    continue;
                }

                int target = 0 - (nums[i] + nums[j]);

                while(right >j && nums[right] > target) {
                    right--;
                }

                if(right <= j) {
                    break;
                }

                if(nums[right] == target) {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(nums[i]);
                    newList.add(nums[j]);
                    newList.add(nums[right]);

                    rltList.add(newList);
                }
            }
        }
        return rltList;
    }

    public static void main(String[] args) {
        Solution tester = new Solution();
        //List<List<Integer>> rltList = tester.threeSum(new int[]{-1,0,1,2,-1,-4});
        List<List<Integer>> rltList = tester.threeSum(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4});
        //List<List<Integer>> rltList = tester.threeSum(new int[]{-2,0,1,1,2});
        //List<List<Integer>> rltList = tester.threeSum(new int[]{0,0,0,0});
        //List<List<Integer>> rltList = tester.threeSum(new int[]{-2,0,0,2,2});
        //List<List<Integer>> rltList = tester.threeSum(new int[]{0,1,1});

        for(List<Integer> entry : rltList) {
            for(Integer tmpInt : entry) {
                System.out.printf("%d,", tmpInt);
            }
            System.out.println("");
                
        }
    }
}
