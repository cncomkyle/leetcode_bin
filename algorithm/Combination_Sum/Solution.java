import java.util.List;
import java.util.ArrayList;

class Solution {

    public void genCombination(int[][] validCandis, int index, int target, int preSum, String preList, List<String> rltList) {
        int data = validCandis[index][0];
        
        int checkData;
        for(int i=0;i<=validCandis[index][1];i++) {

            checkData = preSum + data * i;
            // System.out.printf("%s#%d:%d\n",preList,i, data, checkData);
            if(checkData == target) {
                String newStr = preList;
                for(int j=0;j<i;j++) {
                    newStr = newStr + " " + data;   
                }
                
                rltList.add(newStr);
                return;
            } else if(checkData < target) {
                if(index < validCandis.length - 1) {
                    String newStr = preList;
                    for(int j=0;j<i;j++) {
                        newStr = newStr + " " + data;   
                    }
                    
                    genCombination(validCandis, index + 1, target, checkData, newStr, rltList);
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

        List<String> strRltList = new ArrayList<String>();
        genCombination(validCandis, 0, target, 0, "", strRltList);

        for(String tmpStr : strRltList) {
            List<Integer> item = new ArrayList<Integer>();

            for(String tmp : tmpStr.split(" ")) {
                if("".equals(tmp))continue;
                item.add(Integer.valueOf(tmp));
            }
            result.add(item);
        }

        return result;
        
    }

    public static void main(String[] args) {
        Solution692 ins = new Solution692();

        int[] candis = {2, 3, 6, 7};

        List<List<Integer>> rltList = ins.combinationSum(candis, 7);
        for(List<Integer> tmpList : rltList) {
            for(Integer tmpInt : tmpList) {
                System.out.printf("%d,", tmpInt);
            }
            System.out.println("");
        }
    }
}
