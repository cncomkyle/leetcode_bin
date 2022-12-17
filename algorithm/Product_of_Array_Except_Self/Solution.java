public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        if(length <= 1) {
            return null;
        }

        int[] results = new int[length];

        results[0] = 1;
        for(int i=1;i<length;i++) {
            results[i] = results[i - 1] * nums[i - 1];
        }

        int right = 1;
        for(int i=length -1;i>=0;i--) {
            results[i] *= right;
            right *= nums[i];
        }

        return results;
    }

    public static void printArrays(int[] results) {
        for(int tmp : results) {
            System.out.printf("%d,", tmp);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Solution ins = new Solution();
        printArrays(ins.productExceptSelf(new int[]{1, 2, 3, 4}));
    }
}
