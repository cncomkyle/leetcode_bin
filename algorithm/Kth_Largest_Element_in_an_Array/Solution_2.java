import java.util.Random;
public class Solution_2  {
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        k = nums.length - k;
        int lo = 0, high = nums.length - 1;

        while(lo < high) {
            int j = split(nums, lo, high);

            if(k < j) {
                high = j - 1;
            } else if(k > j) {
                lo = j + 1;
            } else {
                break;
            }
        }

        return nums[k];
    }

    

    public int split(int[] nums, int lo, int high) {
        int i = lo, j = high + 1;
        while(true) {
            while(i < high && nums[++i] < nums[lo]);
            while(j > lo && nums[lo] < nums[--j]);

            if(i>=j) {
                break;
            }

            exchange(nums, i, j);
        }

        exchange(nums, lo, j);
        return j;
    }

    private void exchange(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void shuffle(int[] nums) {
        Random random = new Random();

        int size = nums.length;
        for(int i=1;i<size;i++) {
            exchange(nums, i, random.nextInt(i + 1));
        }
    }


    public static void main(String[] args) {
        Solution_2 ins = new Solution_2();
        System.out.println(ins.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(ins.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));

        int size = 100000000;
        int[] testData = new int[size];
        for(int i=0;i<testData.length;i++) {
            testData[i] = size - i;
        }
        System.out.println(ins.findKthLargest(testData, 100));
    }
}
