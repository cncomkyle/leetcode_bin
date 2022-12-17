import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution3 {

    public void genCombination(int[][] validCandis, int index, int target , Integer[] preList, int len, List<List<Integer>> rltList) {
        int data = validCandis[index][0];
        int checkData;
        
        for(int i=0;i<=validCandis[index][1];i++) {
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
                if(index < validCandis.length - 1) {
                    int newLen = len;
                    for(int j=0;j<i;j++) {
                        preList[newLen++]=data;
                    }
                    
                    genCombination(validCandis, index + 1, target - checkData, preList, newLen, rltList);
                }
            } else {
                return;
            }
        }
    }
        
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int validandiNums = 0;
        for(int i : candidates) {
            if(i <= target) {
                validandiNums++;
            }
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(validandiNums==0) {
            return result;
        }
        int[][] validCandis = new int[validandiNums][2];
        validandiNums = -1;
        for(int i : candidates) {
            if(i <= target) {
                validCandis[++validandiNums][0]=i;
                validCandis[validandiNums][1]= target / i;
            }
        }
        // for(int i=0;i<validCandis.length;i++) {
        //     System.out.printf("%d:%d\n", validCandis[i][0], validCandis[i][1]);
        // }
        genCombination(validCandis, 0, target , new Integer[target], 0, result);
        return result;
    }

    public static void main(String[] args) {
        Solution3 ins = new Solution3();

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
