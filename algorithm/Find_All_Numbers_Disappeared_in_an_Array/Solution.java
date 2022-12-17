import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<Integer> findDisappearedNumbers_old(int[] nums) {
        List<Integer> rltList = new ArrayList<>();
        if(nums.length == 0) {
            return rltList;
        }
        for(int i=0;i<nums.length;i++) {
            rltList.add(i+1);
        }

        for(int i=0, j=nums.length -1; i<=j;i++, j--) {
            rltList.remove(new Integer(nums[i]));
            rltList.remove(new Integer(nums[j]));
        }
        
        return rltList;
    }


    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
            for(int j =0 ;j<nums.length;j++) {
                System.out.printf("%d,", nums[j]);
            }
            System.out.println("");

        }

        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }


    public static void printList(List<Integer> list) {
        for(Integer tmp : list) {
            System.out.printf("%d,", tmp);
        }

        System.out.println("");
    }


    public static void main(String[] args) {
        Solution ins = new Solution();

        printList(ins.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}
