import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class Solution {

    public boolean checkString(String s, Map<String, List<String>> wordMap) {
        String firstStr = s.substring(0, 1);
        List<String> wordList = wordMap.get(firstStr);
        if(wordList == null) {
            return false;
        }
        int s_size = s.length();
        int word_size = -1;
        for(String tmpWord : wordList) {
            word_size = tmpWord.length();
            if(word_size > s_size) {
                continue;
            }
            if(tmpWord.equals(s.substring(0, word_size))) {
                if(word_size == s_size
                   || checkString(s.substring(word_size), wordMap)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean newCheckString(String s, Map<String, List<String>> wordMap) {
        Stack<String> stack = new Stack<>();

        stack.push(s);

        String checkStr = null;
        
        while(stack.size() > 0) {
            checkStr = stack.pop();

            String firstStr = checkStr.substring(0, 1);
            List<String> wordList = wordMap.get(firstStr);
            if(wordList == null) {
                continue;
            }

            int s_size = checkStr.length();
            int word_size = -1;
            for(String tmpWord : wordList) {
                word_size = tmpWord.length();
                if(word_size > s_size) {
                    continue;
                }
                if(tmpWord.equals(checkStr.substring(0, word_size))) {
                    if(word_size == s_size) {
                        return true;
                    } else {
                        stack.push(checkStr.substring(word_size));
                    }
                }
            }

        }
        return false;
    }

    public void addWordMap(Map<String, List<String>> wordMap, String word) {
        String firstStr = word.substring(0,1);
        List<String> wordList = wordMap.get(firstStr);
        if(wordList == null) {
            wordList = new ArrayList<>();
            wordMap.put(firstStr, wordList);
        }
        wordList.add(word);
    }

    
    public boolean wordBreak_old(String s, List<String> wordDict) {
        if(wordDict == null
           || wordDict.size() == 0) {
            return false;
        }
        Collections.sort(wordDict, new Comparator<String>() {

                public int compare(String a1, String a2) {
                    return a1.length() - a2.length();
                }
            });
        Map<String, List<String>> wordMap = new HashMap<>();
        addWordMap(wordMap, wordDict.get(0));
        
        for(int i =1;i<wordDict.size();i++) {
            String tmpWord = wordDict.get(i);
            if(tmpWord == null
               || tmpWord.trim().length() == 0) {
                continue;
            }
            
            if(!newCheckString(tmpWord, wordMap)) {
                addWordMap(wordMap, tmpWord);
            }
        }


        return newCheckString(s, wordMap);
    }

    public boolean wordBreak(String s, List<String> dict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        for(int i=1;i<=s.length();i++) {
            for(String tmpWord : dict) {
                if(tmpWord.length() > i) {
                    continue;
                }

                if(f[i - tmpWord.length()]
                   && tmpWord.equals(s.substring(i- tmpWord.length(), i))) {
                    f[i] = true;
                }
            }
        }

        return f[s.length()];
    }


    public boolean wordBreak_dp1(String s, List<String> dict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        for(int i=1;i<=s.length();i++) {
            for(int j=0;j<i;j++) {
                if(f[j] && dict.contains(s.substring(j,i))) {
                    f[i] = true;
                }
            }
        }

        return f[s.length()];
    }



    public boolean wordBreak_official(String s, List<String> dict) {
        
        boolean[] f = new boolean[s.length() + 1];
        
        f[0] = true;
        
        
        // First DP
        // for(int i = 1; i <= s.length(); i++){
        //     for(String str: dict){
        //         if(str.length() <= i){
        //             if(f[i - str.length()]){
        //                 if(s.substring(i-str.length(), i).equals(str)){
        //                     f[i] = true;
        //                     break;
        //                 }
        //             }
        //         }
        //     }
        // }
        
        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }

    public static void main(String[] args) {
        Solution692 ins = new Solution692();

        String[] words = {"leet", "code"};
        System.out.println(ins.wordBreak("leetcode", Arrays.asList(words)));

        System.out.println(ins.wordBreak("applepenapple", Arrays.asList(new String[]{"apple", "pen"})));

        System.out.println(ins.wordBreak("catsandog", Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"})));

        System.out.println(ins.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList(new String[]{"aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa", "a"})));

        System.out.println(ins.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList(new String[]{"a"})));

        System.out.println(ins.wordBreak("aaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Arrays.asList(new String[]{"aa", "aaa", "ba"})));        

        System.out.println(ins.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Arrays.asList(new String[]{"aa", "aaa", "ba"})));        

        System.out.println(ins.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Arrays.asList(new String[]{"aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa", "ba"})));        
    }
}
