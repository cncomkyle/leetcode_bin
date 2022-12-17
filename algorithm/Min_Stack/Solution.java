import java.util.List;
import java.util.ArrayList;

public class Solution {
    
    public static class MinStack {

        private List<Integer> stackList;
        private List<Integer> minList;

        private int topIndex = -1;
        private int  minVal = 0;

        /** initialize your data structure here. */
        public MinStack() {
            stackList = new ArrayList<>();
            minList = new ArrayList<>();
        }
    
        public void push(int x) {
            stackList.add(x);
            if(topIndex < 0) {
                minVal = x;
            } else {
                minVal = Math.min(minVal, x);
            }
            topIndex++;
            minList.add(minVal);
        }
    
        public void pop() {
            if(topIndex < 0) return;
            stackList.remove(topIndex);
            minList.remove(topIndex);
            topIndex--;
            if(topIndex < 0) return;
            minVal = minList.get(topIndex);
        }
    
        public int top() {
            if(topIndex < 0) {
                return -1;
            }
            return stackList.get(topIndex);
        }
    
        public int getMin() {
            if(topIndex >= 0) {
                return minVal;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-1);
        obj.push(-2);
        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.getMin());
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
