import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public String decodeString_self(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        List<DecodeEntry> entryList = new ArrayList<>();
        Stack<DecodeEntry> stack = new Stack<>();

        int normalIdx = -1;
        int cntIdx = -1;

        String normalStr = null;
        String cntStr = null;

        for(int i=0;i<s.length();i++) {
            char tmp = s.charAt(i);

            if((tmp >='a' && tmp <='z') || (tmp >='A' && tmp <='Z')) {
                if(normalIdx < 0) {
                    normalIdx = i;
                }
            } else if(tmp >='0' && tmp <= '9') {
                if(cntIdx < 0) {
                    cntIdx = i;
                    if(normalIdx >= 0) {
                        normalStr = s.substring(normalIdx, i);
                        DecodeEntry normalEntry = new DecodeEntry();
                        normalEntry.entryStr = normalStr;
                        normalIdx = -1;

                        if(stack.size() > 0) {
                            stack.peek().entryList.add(normalEntry);
                        } else {
                            entryList.add(normalEntry);
                        }
                    }

                }
            } else {
                switch(tmp) {
                case '[':
                    cntStr = s.substring(cntIdx, i);
                    cntIdx = -1;
                    DecodeEntry decodeEntry = new DecodeEntry();
                    decodeEntry.decodeFlg = true;
                    decodeEntry.cnt = Integer.parseInt(cntStr);
                    if(stack.size() > 0) {
                        stack.peek().entryList.add(decodeEntry);
                    } else {
                        entryList.add(decodeEntry);
                    }
                    stack.push(decodeEntry);
                    break;
                case ']':
                    if(normalIdx >= 0) {
                        normalStr = s.substring(normalIdx, i);
                        DecodeEntry normalEntry = new DecodeEntry();
                        normalEntry.entryStr = normalStr;
                        normalIdx = -1;

                        if(stack.size() > 0) {
                            stack.peek().entryList.add(normalEntry);
                        } 
                    }
                    stack.pop();
                    break;
                }
            }
        }

        if(normalIdx >=0 && stack.size() == 0) {
            normalStr = s.substring(normalIdx, s.length());
            DecodeEntry normalEntry = new DecodeEntry();
            normalEntry.entryStr = normalStr;
            normalIdx = -1;

            entryList.add(normalEntry);
        }
        
        StringBuilder sb = new StringBuilder();
        for(DecodeEntry entry : entryList) {
            sb.append(entry.toString());
        }

        return sb.toString();
    }

    class DecodeEntry {
        int cnt = 1;
        String entryStr = null;
        boolean decodeFlg = false;
        List<DecodeEntry> entryList = new ArrayList<>();

        public String toString() {
            if(!this.decodeFlg) {
                return entryStr;
            }
            StringBuilder sb = new StringBuilder();
            for(DecodeEntry entry : this.entryList) {
                sb.append(entry.toString());
            }

            StringBuilder newSb = new StringBuilder();
            for(int i=0;i<cnt;i++) {
                newSb.append(sb.toString());
            }

            return newSb.toString();
        }
    }

    public String createNewString(String cntStr, String pattern) {
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(cntStr);
        for(int i = 0;i<cnt;i++) {
            sb.append(pattern);
        }
        return sb.toString();
    }

    public String decodeString(String s, AtomicInteger i) {
        StringBuilder sb = new StringBuilder();

        char tmp;
        while(i.get() < s.length()) {
            // System.out.println(i.get());
            tmp = s.charAt(i.get());
            if(tmp == ']') {
                break;
            }

            if(!(tmp >='0' && tmp <='9')) {
                sb.append(tmp);
                i.incrementAndGet();
            } else {
                int n = 0;
                while(i.get() < s.length() && (s.charAt(i.get()) >= '0' && s.charAt(i.get()) <= '9')) {
                    n = n * 10 + (s.charAt(i.get()) - '0');
                    i.incrementAndGet();
                }
               
                i.incrementAndGet();
                String t = decodeString(s, i);
                i.incrementAndGet();

                while(n-- > 0) {
                    sb.append(t);
                }
            }
        }
        
        return sb.toString();
        
    }

    public String decodeString(String s) {
        return decodeString(s, new AtomicInteger(0));
    }
    

    public static void main(String[] args) {
        Solution692 ins = new Solution692();
        System.out.println(ins.decodeString("3[a]2[bc]"));
        System.out.println(ins.decodeString("3[a2[c]]"));
        System.out.println(ins.decodeString("2[abc]3[cd]ef"));
        System.out.println(ins.decodeString("3[a]2[b4[F]c]"));
        
    }
}
