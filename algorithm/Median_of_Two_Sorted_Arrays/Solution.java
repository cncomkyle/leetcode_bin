class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int newArrayLengh = totalLength / 2 + 1;
        
        boolean oddFlag = true;
        if(totalLength % 2 == 0) {
            oddFlag = false;
        }
        int[] newArray = new int[newArrayLengh];
        int i = 0, j = 0, k = 0;
        int tmpVal;
        while(k < newArrayLengh ) {
            if(i < nums1.length && j < nums2.length) {
                if(nums1[i] <= nums2[j]) {
                    tmpVal = nums1[i++];
                } else {
                    tmpVal = nums2[j++];
                }
            } else if(i < nums1.length) {
                tmpVal = nums1[i++];
            } else {
                tmpVal = nums2[j++];
            }
            newArray[k++] = tmpVal;
        }

        if(oddFlag) {
            return newArray[newArrayLengh - 1] + 0.0;
        } else {
            return (newArray[newArrayLengh - 1] + newArray[newArrayLengh - 2]) / 2.0;
        }
        
    }
}
