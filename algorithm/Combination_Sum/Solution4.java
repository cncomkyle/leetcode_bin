import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution4 {

    public void genCombination(int[] candidates, int index, int target , Integer[] preList, int len, List<List<Integer>> rltList) {
        int data = candidates[index];
        int checkData;
        int loopcnt = target / data;
        
        for(int i=0;i<=loopcnt;i++) {
            checkData = data * i;
            // System.out.printf("%d:%d\n",len, i);
            if(checkData == target) {
                for(int j=0;j<i;j++) {
                    preList[len++]=data;
                }
                Integer[] newArray = new Integer[len];
                System.arraycopy(preList, 0, newArray, 0, len);
                rltList.add(Arrays.asList(newArray));
                return;
            } else if(checkData < target) {
                if(index < candidates.length - 1) {
                    int newLen = len;
                    for(int j=0;j<i;j++) {
                        preList[newLen++]=data;
                    }
                    
                    genCombination(candidates, index + 1, target - checkData, preList, newLen, rltList);
                }
            } else {
                return;
            }
        }
    }
        
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates.length==0) {
            return result;
        }
        
        genCombination(candidates, 0, target , new Integer[target], 0, result);
        return result;
    }

    public static void main(String[] args) {
        Solution4 ins = new Solution4();

        int[] candis = {2, 3, 5};

        List<List<Integer>> rltList = ins.combinationSum(candis, 8);
        for(List<Integer> tmpList : rltList) {
            for(Integer tmpInt : tmpList) {
                System.out.printf("%d,", tmpInt);
            }
            System.out.println("");
        }
    }
}
