public class Solution {
    public int findDuplicate(int[] nums) {
        if(nums.length == 0) {
            return -1;
        }

        int cnt = 0;
        for(int i=1;i<=nums.length;i++) {
            cnt = 0;
            for(int num : nums) {
                if(i == num) {
                    cnt++;
                    if(cnt > 1) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution692 ins = new Solution692();
        System.out.println(ins.findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(ins.findDuplicate(new int[]{3, 1, 3, 4, 2}));
        System.out.println(ins.findDuplicate(new int[]{2,2,2,2,2}));
    }
}
