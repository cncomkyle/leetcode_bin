import java.util.*;

public class Solution {
    private int getLeftIndex(String s, int leftIndex, int leftCnt, int i) {
        if(leftIndex - 1 < 0) {
            return -1;
        }
        char checkChar = s.charAt(leftIndex  - 1);
        if(checkChar == '(' || checkChar == '[' || checkChar == '{') {
            return  leftIndex - 1;
        }
        return i - leftCnt * 2;
    }
    
    public boolean isValid_old(String s) {
        if(s.length() <= 1) return false;
        int leftIndex = -1;
        int preLeftIndex = leftIndex;
        int leftCnt = 0;
        for(int i=0;i<s.length();i++) {
            char tmpChar = s.charAt(i);
            if(tmpChar == '(' || tmpChar == '{' || tmpChar == '[') {
                leftIndex=i;
                
            } else {
                if(leftIndex < 0) return false;
                if(tmpChar == ')') {
                    if(s.charAt(leftIndex) == '(') {
                        leftCnt++;
                        leftIndex= getLeftIndex(s, leftIndex, leftCnt, i);
                    } else {
                        return false;
                    }
                }
                if(tmpChar == '}') {
                    if(s.charAt(leftIndex) == '{') {
                        leftCnt++;

                        leftIndex= getLeftIndex(s, leftIndex, leftCnt, i);
                    } else {
                        return false;
                    }
                }
                if(tmpChar == ']') {
                    if(s.charAt(leftIndex) == '[') {
                        leftCnt++;

                        leftIndex= getLeftIndex(s, leftIndex, leftCnt, i);
                    } else {
                        return false;
                    }
                }

                System.out.printf("%d : %d\n", leftIndex, leftCnt);
            }
        }

        return leftCnt *2 == s.length();
    }


    public boolean isValid(String s) {
        if(s.length() <= 1) return false;

        LinkedList<Character> stack = new LinkedList<>();
        
        for(int i=0;i<s.length();i++) {
            char tmpChar = s.charAt(i);
            if(tmpChar == '(' || tmpChar == '{' || tmpChar == '[') {
                stack.push(tmpChar);
                
            } else {
                if(stack.size() == 0) return false;
                char checkChar = stack.pop();
                if(tmpChar == ')') {
                    if(checkChar != '(') {
                        return false;
                    }
                }
                if(tmpChar == ']') {
                    if(checkChar != '[') {
                        return false;
                    }
                }
                if(tmpChar == '}') {
                    if(checkChar != '{') {
                        return false;
                    }
                }

            }
        }

        return stack.size() == 0;
    }

    public static void main(String[] args) {
        Solution tester = new Solution();
        boolean rlt = tester.isValid("[()[[]()]]");
        System.out.println("rlt is " + rlt);
    }
}
