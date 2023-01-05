import java.util.List;
import java.util.ArrayList;


public class Solution {
    public List<Integer> findAnagrams_old(String s, String p) {
        int s_size = s.length();
        int p_size = p.length();
        List<Integer> rltList = new ArrayList<>();
        if(s_size < p_size) {
            return rltList;
        }
        for(int i=0;i<s_size - p_size+1;i++) {
            if(isAnagram(p, s.substring(i, i + p_size))) {
                rltList.add(i);
            }
        }

        return rltList;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] s_map = new int[26];
        for(int i=0;i<s.length();i++) {
            s_map[s.charAt(i) - 'a']++;
        }
        int tmp;
        for(int i=0;i<t.length();i++) {
            tmp = t.charAt(i) - 'a';
            s_map[tmp]--;
            if(s_map[tmp] < 0) {
                return false;
            } 
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256]; //character hash
        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right++)]-- >= 1) count--; 
        
            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) list.add(left);
    
            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            // if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
            if(right - left == p.length()) {
                System.out.printf("left hash:%d,", hash[s.charAt(left)]);
                if(hash[s.charAt(left++)]++>=0) {
                    count++;
                }
            }
            

            System.out.printf("left:%d,right:%d,count:%d\n",left, right, count);
        }
        return list;
    }

    public static void printList(List<Integer> list) {
        for(Integer tmp : list) {
            System.out.printf("%d,", tmp);
        }

        System.out.println("");
    }

    public static void main(String[] args) {
        Solution692 ins = new Solution692();

        // printList(ins.findAnagrams("cbaebabacd", "abc"));
        // printList(ins.findAnagrams("abab", "ab"));

        printList(ins.findAnagrams("cdcdad", "ab"));
    }
    
}
