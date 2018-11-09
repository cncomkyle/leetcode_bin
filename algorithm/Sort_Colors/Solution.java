public class Solution {

    public void printNums(int[] nums) {
        for(int tmp : nums) {
            System.out.printf("%d ",tmp);
        }
        System.out.println("");
    }
    
    public void sortColors_old(int[] nums) {
        int index0 = 0;
        int index2 = nums.length - 1;
        for(int i=0;i<nums.length;i++) {
            System.out.printf("i:%d, 0:%d, 2:%d\n",i, index0, index2);
            printNums(nums);

            switch(nums[i]) {
            case 0:

                while(index0<nums.length
                      &&nums[index0]==0) {
                    index0++;
                }
                if(index0==nums.length)return;
                if(i<index0) {
                    i=index0-1;
                    continue;  
                } 

                nums[i] = nums[index0];
                nums[index0++] = 0;

                break;
            case 1:
                break;
            case 2:

                while(index2>=0
                      && nums[index2]==2) {
                    index2--;
                }
                if(index2<0)return;
                if(i>index2) {
                    return;
                }
                
                nums[i] = nums[index2];
                nums[index2--] = 2;

                if(nums[i]==0)i--;

                break;
            }

        }
    }

    public void sortColors(int[] nums) {
        // 1-pass
        int p1 = 0, p2 = nums.length - 1, index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            else if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }
            index++;
        }
    }

    public static void main(String[] args) {
        Solution ins = new Solution();
        int[] nums = {1,2,0};
        ins.sortColors(nums);

        ins.printNums(nums);
    }
}
