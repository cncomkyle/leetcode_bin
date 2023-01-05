import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        
        Map<Character, Integer> charMap = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        charMap.put(s.charAt(start), start);
        int i = 1;
        for(;i<s.length();i++) {
            // check the next char
            if(charMap.containsKey(s.charAt(i)) && charMap.get(s.charAt(i)) + 1 > start) {
                maxLength = Math.max(maxLength, i - start);
                start = charMap.get(s.charAt(i)) + 1;
            }

            charMap.put(s.charAt(i), i);

        }
        
        maxLength = Math.max(maxLength, i - start);

        return maxLength;
    }

    public int lengthOfLongestSubstring_official(String s) {
        Set<Character> charSet = new HashSet<>();

        int right = -1, maxLength = 0;
        for(int left = 0;left < s.length();left++) {

            while(right + 1 < s.length()  && !charSet.contains(s.charAt(right + 1))) {
                right++;
                charSet.add(s.charAt(right));
            }
            charSet.remove(s.charAt(left));
            maxLength = Math.max(maxLength, right - left + 1);
            
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution tester = new Solution();

        // 3
        int rlt = tester.lengthOfLongestSubstring("abcabcbb");
        System.out.println(rlt);

        // 1
        rlt = tester.lengthOfLongestSubstring("bbbbb");
        System.out.println(rlt);

        // 3
        rlt = tester.lengthOfLongestSubstring("pwwkew");
        System.out.println(rlt);

        // 1
        rlt = tester.lengthOfLongestSubstring(" ");
        System.out.println(rlt);

        // 2
        rlt = tester.lengthOfLongestSubstring("au");
        System.out.println(rlt);

        // 3
        rlt = tester.lengthOfLongestSubstring("dvdf");
        System.out.println(rlt);

        // 2
        rlt = tester.lengthOfLongestSubstring("abba");
        System.out.println(rlt);
    }
}
