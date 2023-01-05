public class Solution {
    public int hammingDistance_old(int x, int y) {
        if(x == y) {
            return 0;
        }

        int xor = x ^ y;
        int result = 0;
        for(int i=0;i<32;i++) {
            result += xor >> i & 1;
        }
        return result;
    }


    public int hammingDistance(int x, int y) {
        if(x == y) {
            return 0;
        }

        int result = x ^ y;

        result = result - ((result >>> 1) & 0x55555555);
        result = (result & 0x33333333) + ((result >>> 2) & 0x33333333);
        result = (result + (result >>> 4)) & 0x0f0f0f0f;
        result = result + (result >>> 8);
        result = result + (result >>> 16);

        return result & 0x3f;
    }

    public static void main(String[] args) {
        Solution692 ins = new Solution692();

        System.out.println(ins.hammingDistance(1, 4));
    }
}
