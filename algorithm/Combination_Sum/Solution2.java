import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        search(candidates, 0, target, new Integer[target], 0, ans);
        return ans;
    }
    
    private void search(int[] candidates, int st,
                        int target,
                        Integer[] paper, int len,
                        List<List<Integer>> ans) {
        if (target == 0) {
            Integer[] temp = new Integer[len];
            System.arraycopy(paper, 0, temp, 0, len);
            ans.add(Arrays.asList(temp));
            return;
        }

        for(int i=st; i<candidates.length; i++) {
            if (target < candidates[i]) break;
            paper[len] = candidates[i];
            search(candidates, i, target-candidates[i], paper, len+1, ans);
        }
    }


    public static void main(String[] args) {
        Solution2 ins = new Solution2();

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
