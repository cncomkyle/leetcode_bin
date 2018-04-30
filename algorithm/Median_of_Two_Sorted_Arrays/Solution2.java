class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int newArrayLengh = totalLength / 2 + 1;
        
        boolean oddFlag = true;
        if(totalLength % 2 == 0) {
            oddFlag = false;
        }

        int i = 0, j = 0, k = 0, tmp = 0;
        int medianVal = 0, preVal = 0;

        int[] tmpArray1 = nums1, tmpArray2 = nums2;

        if(nums1.length == 0 
           || (nums2.length > 0 && nums2[nums2.length - 1] >= nums1[0])) {
            tmpArray1 = nums2;
            tmpArray2 = nums1;
        }

        if(tmpArray1.length >= newArrayLengh
           && (tmpArray2.length == 0 || tmpArray1[tmpArray1.length -1] <= tmpArray2[0] )) {
            if(!oddFlag) {
                return (tmpArray1[newArrayLengh -1] + tmpArray1[newArrayLengh - 2]) / 2.0;
            } else {
                return tmpArray1[newArrayLengh -1];
            }
        }
            
        while(k++ < newArrayLengh ) {
            preVal = medianVal;
            medianVal = tmpArray1[i];
            if(medianVal < tmpArray2[0]) {
                i++;
                continue;
            } 

            medianVal = tmpArray2[j++];
            break;
        }

        // System.out.printf("%d:%d:%d\n", i, j, k);
        
        while(k < newArrayLengh ) {
            preVal = medianVal;
            
            if(i < tmpArray1.length && j < tmpArray2.length) {
                if(tmpArray1[i] <= tmpArray2[j]) {
                    medianVal = tmpArray1[i++];
                } else {
                    medianVal = tmpArray2[j++];
                }
            } else if(i < tmpArray1.length) {
                tmp = i + (newArrayLengh - k) - 1;
                medianVal = tmpArray1[tmp];
                if((newArrayLengh - k) > 1) {
                    preVal = tmpArray1[tmp - 1];
                }
                break;
            } else {
                tmp = j + (newArrayLengh - k) - 1;
                medianVal = tmpArray2[tmp];
                if((newArrayLengh - k) > 1) {
                    preVal = tmpArray2[tmp - 1];
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

    public static void main(String[] args) {
        Solution2 ins = new Solution2();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(ins.findMedianSortedArrays(nums1, nums2));
    }
}
