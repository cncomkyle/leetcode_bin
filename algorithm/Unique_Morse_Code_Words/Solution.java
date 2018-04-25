public class Solution {
    private static String[] charMorseArray = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public long getWordNum(String word) {
        long result = 1;
        for(char tmpChar : word.toCharArray()) {
            for(char tmpMorse : charMorseArray[tmpChar - 'a'].toCharArray()) {
                result = result << 1;
                if(tmpMorse=='-') {
                    result |= 1;
                }
            }
        }
        return result;
    }
    
    public int uniqueMorseRepresentations(String[] words) {
        
        int result = 0;
        long[] wordNum = new long[words.length];
        for(int i=0;i<words.length;i++) {
            wordNum[i] = getWordNum(words[i]);
        }

        for(int i=0;i<wordNum.length;i++) {
            if(wordNum[i] == 0) {
                continue;
            }
            for(int j=i+1;j<wordNum.length;j++) {
                if(wordNum[j] == 0) {
                    continue;
                }
                if(wordNum[i] == wordNum[j]) {
                    wordNum[j] = 0;
                }
            }
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        Solution instance = new Solution();
        System.out.println(instance.uniqueMorseRepresentations(words));
    }
}
