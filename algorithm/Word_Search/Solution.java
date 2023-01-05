import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Solution {

    public boolean checkChar(Map<String, List<Integer>> charIndexMap, int preIndex, int matchCnt, String word, int colNum) {
        // System.out.printf("matchCnt:%d, preIndex:%d \n",matchCnt, preIndex);
        String checkChar = word.charAt(matchCnt) + "";
        List<Integer> indexList = charIndexMap.get(checkChar);
        if(indexList == null) {
            return false;
        }

        for(int i=0;i< indexList.size();i++) {
            int tmpIndex = indexList.get(i);
            if(tmpIndex < 0) {
                continue;
            }
            if(preIndex == 0
               || (tmpIndex == preIndex + 1 && !(preIndex/colNum>=1&&preIndex%colNum==0))
               || (tmpIndex == preIndex -1 && !(tmpIndex/colNum>=1&&tmpIndex%colNum==0))
               || tmpIndex == preIndex + colNum
               || tmpIndex == preIndex - colNum) {

                indexList.set(i, -1 * tmpIndex);
                matchCnt++;
                if(matchCnt==word.length()) {
                    return true;
                }
                if(!checkChar(charIndexMap, tmpIndex, matchCnt, word, colNum)) {
                    indexList.set(i, tmpIndex);
                    matchCnt--;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        Map<String, List<Integer>> charIndexMap = new HashMap<>(); 

        int rows = board.length;
        int cols = board[0].length;
        List<Integer> charList;
        int row = 0;
        for(char[] rowChars : board) {
            int col = 0;
            for(char tmpChar : rowChars) {
                charList = charIndexMap.get(tmpChar+"");
                if(charList == null) {
                    charList = new ArrayList<>();
                    charIndexMap.put(tmpChar+"", charList);
                }
                charList.add(row * cols + col + 1);
                col++;
            }
            row++;
        }
        
        return checkChar(charIndexMap, 0, 0, word, cols);
    }

    public static void main(String[] args) {
        Solution692 ins = new Solution692();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'} };
        System.out.println(ins.exist(board, "ABCCED"));
        System.out.println(ins.exist(board, "SEE"));
        System.out.println(ins.exist(board, "ABCB"));

        char[][] board_1 = {{'a','a'}};
        System.out.println(ins.exist(board_1, "aaa"));

        char[][] board_2 = {{'a','b'},{'c','d'}};
        System.out.println(ins.exist(board_2, "abcd"));
        System.out.println(ins.exist(board_2, "acdb"));
    }
}
