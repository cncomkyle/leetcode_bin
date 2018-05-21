class SolutionDP {
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        int[] dpArray = new int[s.length()];
        char tmpChar;
        for(int i=1;i<s.length();i++) {
            tmpChar = s.charAt(i);
            if(tmpChar=='(') {
                dpArray[i]=0;
            } else {
                if(s.charAt(i-1)=='(') {
                    dpArray[i]=(i>=2?dpArray[i-2]:0) + 2;
                } else {
                    if((i -1 + 1 - dpArray[i - 1] - 1 ) >= 0
                       && s.charAt(i -1 + 1 - dpArray[i - 1] - 1) == '(') {
                        dpArray[i] = dpArray[i - 1] + 2 + ((i - 1 + 1 - dpArray[i-1] - 1 - 1 >= 0) ? dpArray[i - 1 + 1 - dpArray[i-1] - 1 - 1]:0);
                    }
                }
            }

            if(maxLength < dpArray[i]) {
                maxLength = dpArray[i];
            }
        }

        return maxLength;
    }
        
    public static void main(String[] args) {
        SolutionDP ins = new SolutionDP();

        System.out.println(ins.longestValidParentheses(")()())"));
        System.out.println(ins.longestValidParentheses("(()"));
        System.out.println(ins.longestValidParentheses("()(()"));
        System.out.println(ins.longestValidParentheses("(()((((()"));
        System.out.println(ins.longestValidParentheses(")(())))(())())"));
        System.out.println(ins.longestValidParentheses("()(()()"));
        System.out.println(ins.longestValidParentheses("()(())"));
        System.out.println(ins.longestValidParentheses(""));
        System.out.println(ins.longestValidParentheses("("));
        System.out.println(ins.longestValidParentheses("((((((("));

    }
}
