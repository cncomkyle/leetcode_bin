import java.util.Random;

public class Solution2 {
    private final static Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;

        int left = 0;
        int right = len - 1;

        while(true) {
            int pivotIndex = partition(nums, left, right);
            if(pivotIndex == target) {
                return nums[pivotIndex];
            } else if(pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);


        int pivot = nums[left];
        int le = left + 1;
        int ge = right;

        while(true) {
            while(le <= ge && nums[le] < pivot) {
                le++;
            }

            while(le <= ge && nums[ge] > pivot) {
                ge--;
            }

            if(le >= ge) {
                break;
            }

            swap(nums, le, ge);
            le++;
            ge--;
        }

        swap(num, left, ge);
        return ge;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    
}
