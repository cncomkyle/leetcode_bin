class Solution {
    public int climbStairs(int n) {
        if(n==0) {
            return 0;
        }
        if(n==1) {
            return 1;
        }
        int result = 0;
        int pre_1=1, pre_2=1;
        for(int i=2;i<=n;i++) {
            result = pre_1 + pre_2;
            pre_2 = pre_1;
            pre_1 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution692 ins = new Solution692();
        System.out.println(ins.climbStairs(4));
    }
}
