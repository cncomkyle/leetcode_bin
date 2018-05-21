class SolutionStack {
    public int longestValidParentheses(String s) {
        if(s.length() < 2 ) {
            return 0;
        }
        
        int maxLength = 0;
        int[] stack = new int[s.length()+1];
        int stackIndex=-1;
        stack[++stackIndex] = -1;
        
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='(') {
                stack[++stackIndex] = i;
            } else {
                stackIndex--;

                if(stackIndex < 0) {
                    stack[++stackIndex] = i;
                } else {
                    if((i - stack[stackIndex]) > maxLength) {
                        maxLength = i - stack[stackIndex];
                    }
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        SolutionStack ins = new SolutionStack();

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
