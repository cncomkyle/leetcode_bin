public class Solution {
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

    public static void main(String[] args) {
        Solution692 ins = new Solution692();
        System.out.println(ins.isAnagram("anagram", "nagaram"));
        System.out.println(ins.isAnagram("rat", "car"));
        System.out.println(ins.isAnagram("ab", "b"));
    }
}
