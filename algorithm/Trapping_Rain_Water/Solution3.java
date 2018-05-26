class Solution3 {
    public int trap(int[] height) {
        if(height.length == 0) {
            return 0;
        }
        int sum = 0;
        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        while(left < right) {
            if(height[left] <= height[right]) {
                if(maxLeft < height[left]) {
                    maxLeft = height[left];
                } else {
                    sum += (maxLeft - height[left]);
                }
                left++;
            } else {
                if(maxRight < height[right]) {
                    maxRight = height[right];
                } else {
                    sum += (maxRight - height[right]);
                }
                right--;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution3 ins = new Solution3();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        //height = new int[]{4, 2, 3};
        System.out.println(ins.trap(height));
    }
}
