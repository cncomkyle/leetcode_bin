class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left=0, right=height.length - 1;

        int tmp = 0;
        while(left < right) {
            if(height[left] <= height[right]) {
                tmp = (right - left) * height[left++];
            } else {
                tmp = (right - left) * height[right--];
            }
            if(maxArea < tmp) {
                maxArea = tmp;
            }
        }
        
        return maxArea;
    }
}
