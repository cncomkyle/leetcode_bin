class Solution1 {
    public boolean isMatch(String s, String p) {
        if(s == null
           || p == null) {
            return false;
        }

        if(s.length() > 0
           && p.length() > 0) {
            char tmpHs = s.charAt(0);
            char tmpHp = p.charAt(0);
            
            if(tmpHs - 'a' >= 0
               && tmpHs - 'z' <= 0
               && tmpHp - 'a' >= 0
               && tmpHp - 'z' <= 0
               && tmpHs -tmpHp != 0) {
                if(!(p.length() >1 && p.charAt(1) == '*')) {
                    return false;
                }
            }

            char tmpTs = s.charAt(s.length() - 1);
            char tmpTp = p.charAt(p.length() - 1);

            if(tmpTs - 'a' >= 0
               && tmpTs - 'z' <= 0
               && tmpTp - 'a' >= 0
               && tmpTp - 'z' <= 0
               && tmpTs -tmpTp != 0) {
                return false;
            }
        }

        // get * count
        int count = 0;
        char[] tmpChars = p.toCharArray();
        for(char tmp : tmpChars) {
            if(tmp == '*') {
                count++;
            }
        }

        char[] pArray = new char[count + p.length() - count * 2];
        char starFlag = (char)((byte)1 << 7);
        
        for(int i=0, j=0;i<tmpChars.length;j++) {
            pArray[j] = tmpChars[i++];
            if(i < tmpChars.length
               && tmpChars[i] == '*') {
                pArray[j] |= starFlag;
                i++;
            } 
        }

        byte[][] dp = new byte[pArray.length + 1][s.length() + 2];
        dp[0][0] = 1;
        for(int i=0;i<pArray.length;i++) {
            if((pArray[i] & starFlag) !=0
               &&dp[i][0] == 1) {
                dp[i+1][0] = 1;
                dp[i + 1][s.length()+1] |= 1;
            }
        }

        char tmpChar;
        for(int i=0;i<pArray.length;i++) {
            for(int j=0;j<s.length();j++) {
                tmpChar = (char)(pArray[i] & (~(starFlag)));
                if(s.charAt(j) == tmpChar
                   || tmpChar == '.') {
                    dp[i+1][j+1] = dp[i][j];

                    if((pArray[i] & (starFlag)) > 0) {
                        dp[i+1][j+1] |= dp[i+1][j];
                    }
                }
                if((pArray[i] & (starFlag)) > 0) {
                     dp[i+1][j+1] |=  dp[i][j+1];
                 }
            
                if(dp[i+1][j+1] > 0) {
                    dp[i+1][s.length()+1] |= 1;
                }
            }

            if(dp[i+1][s.length()+1] == 0
               && pArray[i] != '.'
               && (pArray[i] & (starFlag)) == 0) {
                //printValue(pArray, s, dp);
                return false;
            }
        }
        //printValue(pArray, s, dp);
        return dp[pArray.length][s.length()] == 1;
    }

    private static void printValue(char[] pArray, String s, byte[][] dp) {
        for(int i=0;i<s.length()+2;i++) {
            if(i == 0) {
                System.out.printf("   0 ");
            } else if(i == s.length() + 1) {
                System.out.printf("# ");
            } else {
                System.out.printf("%s ",s.charAt(i - 1));    
            }
            
        }
        System.out.printf("\n");
        char tmpChar;
        for(int i=0;i<pArray.length+1 ;i++) {

            System.out.printf("%s%s ", i==0?"0":(char)(pArray[i-1] & (~((byte)1<< 7))), i==0?" ":((pArray[i-1]&((byte)1<<7))>0)?"*":" ");
            for(int j = 0;j<s.length()+2;j++) {
                System.out.printf("%s ", dp[i][j]);
            }

            System.out.printf("\n");
        }
        
    }

    public static void main(String[] args) {
        String s = "abc";
        String p = "abcc*";

        Solution1 ins = new Solution1();
        System.out.println(ins.isMatch(s, p));

        s = "abcc";
        System.out.println(ins.isMatch(s, p));

        s = "abcd";
        System.out.println(ins.isMatch(s, p));

        s = "bbbbab";
        p = "b*.*b*";
        System.out.println(ins.isMatch(s, p));

        s = "a";
        p = "b*b*a";
        System.out.println(ins.isMatch(s, p));

        s = "aa";
        p = "a";
        System.out.println(ins.isMatch(s, p));

        s = "aaa";
        p = "ab*ac*a";
        System.out.println(ins.isMatch(s, p));

        s = "mississippi";
        p="mis*is*p*.";
        System.out.println(ins.isMatch(s, p));

        s = "a";
        p="ab*a";
        System.out.println(ins.isMatch(s, p));


        s = "adcccccccccccdaaaa";
        p="ac.*ea*";
        System.out.println(ins.isMatch(s, p));
    }
}
