import java.util.Map;
import java.util.HashMap;

public class Solution {

    public int numTrees(int n) {
        Map<Integer, Integer> numTreeMap = new HashMap<>();
        numTreeMap.put(0, 0);
        numTreeMap.put(1, 1);
        if(n == 0
           || n == 1) {
            return numTreeMap.get(n);
        }
        int result=0;
        int tmp;
        for(int i=2;i<=n;i++) {
            result = 0;
            result += 2 * numTreeMap.get(i-1);
            for(int j=1;j<=(i-1)/2;j++) {
                tmp = numTreeMap.get(i-1-j) * numTreeMap.get(j);
                if(i-1-j==j) {
                    result += tmp;
                } else {
                    result += 2 * tmp;
                }
                
            }
            // System.out.printf("cnt %d\n",i);
            numTreeMap.put(i,result);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution ins = new Solution();

        System.out.println(ins.numTrees(2));
        System.out.println(ins.numTrees(3));
        System.out.println(ins.numTrees(4));
        System.out.println(ins.numTrees(5));
      
    }
}
