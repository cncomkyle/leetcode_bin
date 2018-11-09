import java.util.List;
import java.util.ArrayList;

public class Solution {
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rltList = new ArrayList<>();

        int allCnt=1;
        for(int i=0;i<nums.length;i++) {
            allCnt*=2;
        }
        int tmpInt;
        
        for(int i=1;i<=allCnt;i++) {
            List<Integer> tmpList = new ArrayList<>();
            for(int j=0;j<nums.length;j++) {
                tmpInt = i>>j;
                if((tmpInt&1)>0) {
                    tmpList.add(nums[nums.length-1-j]);
                }
                if(tmpInt==0)break;
            }
            rltList.add(tmpList);
        }

        return rltList;
    }

    public static void main(String[] args) {
        Solution ins = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> rltList = ins.subsets(nums);

        System.out.println(rltList.size());

        for(List<Integer> tmpList : rltList) {
            System.out.printf("[");
            for(Integer tmpInt : tmpList) {
                System.out.printf("%d,",tmpInt);
            }
            System.out.printf("]\n");
        }
    }
}
