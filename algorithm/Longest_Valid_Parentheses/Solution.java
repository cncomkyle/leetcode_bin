class Solution {
    public int longestValidParentheses(String s) {
        char[] checkArrays = s.toCharArray();

        if(checkArrays.length <= 1) {
            return 0;
        }

        int maxLength = 0;
        int beginCnt = 0;

        int[] openArray = new int[checkArrays.length];
        int[] openStack = new int[checkArrays.length];
        int[] closeStack = new int[checkArrays.length];

        int openIndex = -1;
        int stackIndex = -1;
        int tmpIndex = -1;

        for(int i=0;i<checkArrays.length;i++) {
            if(checkArrays[i]=='(') {
                openArray[++openIndex] = i;
                beginCnt++;
                
            } else if(checkArrays[i]==')') {
                if(beginCnt <= 0) {
                    continue;
                }

                tmpIndex = openArray[openIndex];
                if(maxLength < (i + 1 - tmpIndex)) {
                    maxLength = i + 1 - tmpIndex;
                }
                
                if(stackIndex >=0
                   && openStack[stackIndex] > tmpIndex
                   && closeStack[stackIndex] < i) {
                    stackIndex--;

                }
                
                if(tmpIndex >= 1) {
                    if(checkArrays[tmpIndex - 1] == ')') {
                        if(stackIndex>=0) {
                            if(closeStack[stackIndex] == tmpIndex - 1) {
                                closeStack[stackIndex] = i;

                                if(maxLength < (i + 1 - openStack[stackIndex])) {
                                    maxLength = i + 1 - openStack[stackIndex];
                                }
                            }  else {
                                stackIndex++;
                                openStack[stackIndex] = tmpIndex;
                                closeStack[stackIndex] = i;
                            }
                        }
                    } else {
                        stackIndex++;
                        openStack[stackIndex] = tmpIndex;
                        closeStack[stackIndex] = i;
                    }
                }

                if(stackIndex < 0) {
                    stackIndex++;
                    openStack[stackIndex] = tmpIndex;
                    closeStack[stackIndex] = i;
                }
                beginCnt--;                    
                openIndex--;
            }
        }

        for(int i = 0;i<=stackIndex;i++) {
            System.out.printf("%d:%d\n", openStack[i],closeStack[i]);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution692 ins = new Solution692();

        System.out.println(ins.longestValidParentheses(")()())"));
        System.out.println(ins.longestValidParentheses("(()"));
        System.out.println(ins.longestValidParentheses("()(()"));
        System.out.println(ins.longestValidParentheses("(()((((()"));
        System.out.println(ins.longestValidParentheses(")(())))(())())"));
        System.out.println(ins.longestValidParentheses("()(()()"));
        System.out.println(ins.longestValidParentheses("()(())"));
    }
}
