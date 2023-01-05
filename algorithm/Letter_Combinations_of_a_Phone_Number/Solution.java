import java.util.List;
import java.util.ArrayList;

class Solution {
    private String[] digitMap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> getStringsForDigit(char digit) {
        List<String> result = new ArrayList<String>();
        char[] tmpArray = digitMap[digit - '2'].toCharArray();
        for(char tmp : tmpArray) {
            result.add(String.valueOf(tmp));
        }
        // for(int i=0;i<3;i++) {
        //     result.add(String.valueOf((char)('a' + (digit - '2') * 3 + i)));
        // }

        return result;
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits == null
           || digits.length() == 0) {
            return result;
        }
        if(digits.length() == 1) {
            return getStringsForDigit(digits.charAt(0));
        }

        List<String> postResult = letterCombinations(digits.substring(1));
        List<String> preResult = getStringsForDigit(digits.charAt(0));

        for(String tmpPre : preResult) {
            for(String tmpPost : postResult) {
                result.add(tmpPre + tmpPost);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution692 ins = new Solution692();
        String digits = "23";
        List<String> result = ins.letterCombinations(digits);

        for(String tmp : result) {
            System.out.println(tmp);
        }
    }
}
