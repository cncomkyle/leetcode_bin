class Solution {
    public boolean isValid_fail(String s) {
        char[] charArray = s.toCharArray();
        if(charArray.length % 2 == 1) {
            return false;
        }

        int left = charArray.length / 2 - 1;
        int right= left + 1;
        
        while(left >= 0) {
            switch (charArray[left]) {
            case '[':
                if(charArray[right]!=']') {
                    return false;
                }
                break;
            case ']':
                if(left - 1 < 0
                   || charArray[left-1]!='[') {
                    return false;
                }
                left--;
                break;
            case '{':
                if(charArray[right]!='}') {
                    return false;
                }
                break;
            case '}':
                if(left - 1 < 0
                   || charArray[left-1]!='{') {
                    return false;
                }
                left--;
                break;
            case '(':
                if(charArray[right]!=')') {
                    return false;
                }
                break;
            case ')':
                if(left - 1 < 0
                   || charArray[left-1]!='(') {
                    return false;
                }
                left--;
                break;
            }
            
            left--;
            right++;
        }

        return true;
    }

    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        if(charArray.length % 2 == 1) {
            return false;
        }
        char[] stackArray = new char[charArray.length / 2];
        int lastIndex = -1;
        char tmpChar;
        char checkChar;
        for(int i=0;i<charArray.length;i++) {
            checkChar = '0';
            tmpChar = charArray[i];
            switch(tmpChar) {
            case '(':
            case '{':
            case '[':
                if(lastIndex + 1 >= stackArray.length) {
                    return false;
                }
                stackArray[++lastIndex]=tmpChar;
                break;
            case ')':
                checkChar = '(';
                break;
            case '}':
                checkChar = '{';
                break;
            case ']':
                checkChar = '[';
                break;
            }

            if(checkChar!='0') {
                if(lastIndex < 0) {
                    return false;
                }
                if(stackArray[lastIndex] != checkChar) {
                    return false;
                }
                lastIndex--;
            }
        }

        if(lastIndex >= 0) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution ins = new Solution();

        // true
        System.out.println(ins.isValid("()"));
        // true
        System.out.println(ins.isValid("()[]{}"));
        // false
        System.out.println(ins.isValid("(]"));
        // false
        System.out.println(ins.isValid("([)]"));
        // true
        System.out.println(ins.isValid("{[]}"));
        // true
        System.out.println(ins.isValid("(([]){})"));
         // false
        System.out.println(ins.isValid("(("));
         // false
        System.out.println(ins.isValid("){"));
    }
}
