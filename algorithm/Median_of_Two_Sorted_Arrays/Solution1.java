class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int newArrayLengh = totalLength / 2 + 1;
        
        boolean oddFlag = true;
        if(totalLength % 2 == 0) {
            oddFlag = false;
        }

        int i = 0, j = 0, k = 0, tmp = 0;
        int medianVal = 0, preVal = 0;
        while(k < newArrayLengh ) {
            preVal = medianVal;
            if(i < nums1.length && j < nums2.length) {
                if(nums1[i] <= nums2[j]) {
                    medianVal = nums1[i++];
                } else {
                    medianVal = nums2[j++];
                }
            } else if(i < nums1.length) {
                tmp = i + (newArrayLengh - k) - 1;
                medianVal = nums1[tmp];
                if((newArrayLengh - k) > 1) {
                    preVal = nums1[tmp - 1];
                }
                break;
            } else {
                tmp = j + (newArrayLengh - k) - 1;
                medianVal = nums2[tmp];
                if((newArrayLengh - k) > 1) {
                    preVal = nums2[tmp - 1];
                }
                break;
            }
            k++;
        }

        if(oddFlag) {
            return medianVal + 0.0;
        } else {
            return (medianVal + preVal) / 2.0;
        }
        
    }
}
