import java.util.List;
import java.util.ArrayList;

class Solution {

    public void genPairs(List<String> rltList, int beginCnt, int endCnt, String preStr, int cnt) {
        if(beginCnt == cnt) {
            for(int i=0;i<cnt-endCnt;i++) {
                preStr = preStr + ")";
            }
            rltList.add(preStr);
            return;
        }

        genPairs(rltList, beginCnt + 1, endCnt, preStr + "(", cnt);
        if(endCnt != beginCnt) {
            genPairs(rltList, beginCnt, endCnt + 1, preStr + ")", cnt);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> rltList = new ArrayList<String>();
        genPairs(rltList, 1, 0, "(", n);
        return rltList;
    }


    public static void main(String[] args) {
        Solution692 ins = new Solution692();
        List<String> rltList = ins.generateParenthesis(3);

        for(String tmpStr : rltList) {
            System.out.println(tmpStr);
        }
    }
}
