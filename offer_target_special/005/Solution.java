
public class Solution {

    public int maxProduct(String[] words) {
        int n = words.length;
        int[] mask = new int[n];
        for(int i=0;i<n;i++) {
            for(char ch : words[i].toCharArray()) {
                mask[i] |= 1 << (ch-'a');
            }            
        }
        int ans = 0;
        for (int i=0;i< n-1;i++) {
            for(int j=i+1;j<n;j++) {
                if((mask[i]&mask[j])==0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution tester = new Solution();
        int rlt = tester.maxProduct(new String[]{"abcw","baz","foo","bar","fxyz","abcdef"});
        System.out.println(rlt);
    }
    
}
