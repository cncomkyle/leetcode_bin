

public class Solution {

    public String addBinary(String a, String b) {
        int x = a.length() - 1, y = b.length() -1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;

        while(x>=0 || y>=0) {
            if(x>=0) {
                if(a.charAt(x) == '1') {
                    carry += 1;
                }
                x--;
            }
            if(y>=0) {
                if(b.charAt(y) == '1') {
                    carry +=1;
                }
                y--;
            }

            sb.append((char)((carry & 1) + '0'));
            carry >>=1;
        }
        if(carry == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        Solution tester = new Solution();
        String rlt = tester.addBinary("1001", "1101");
        System.out.println(rlt);
    }
    
}
