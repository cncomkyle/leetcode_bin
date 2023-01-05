class Solution {
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

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for(int i=0;i<p.length();i++) {
            if(p.charAt(i) == '*'
               && dp[0][i - 2 + 1]) {
                dp[0][i+1] = true;
            }
        }

        char tmpS, tmpP, preP;
        for(int i=0;i<s.length();i++) {
            tmpS = s.charAt(i);
            for(int j=0;j<p.length();j++) {
                tmpP = p.charAt(j);
                if(tmpP == tmpS
                   || tmpP == '.') {
                    dp[i+1][j+1] = dp[i][j];
                } else if(tmpP == '*') {
                    preP = p.charAt(j - 1);
                    if(preP != tmpS && preP != '.') {
                        dp[i+1][j+1] = dp[i+1][j - 2 + 1];
                    } else {
                        dp[i+1][j+1] = dp[i+1][j] || dp[i][j+1] || dp[i+1][j - 2 + 1];
                    }
                }
            }
        }

       

        return dp[s.length()][p.length()];
    }

     // for(int i=0;i<p.length()+1;i++) {
     //        if(i == 0) {
     //            System.out.printf("  0 ");
     //        } else {
     //            System.out.printf("%s ",p.charAt(i - 1));    
     //        }
            
     //    }
     //    System.out.printf("\n");
     //    for(int i=0;i<s.length()+1 ;i++) {
     //        System.out.printf("%s ", i==0?"0":s.charAt(i - 1));
     //        for(int j = 0;j<p.length()+1;j++) {
     //            System.out.printf("%s ", dp[i][j]?"1":"0");
     //        }

     //        System.out.printf("\n");
     //    }

    public static void main(String[] args) {
        String s = "abc";
        String p = "abcc*";

        Solution692 ins = new Solution692();
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
    }
}
