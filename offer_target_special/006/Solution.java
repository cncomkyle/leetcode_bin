

public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int i =0 , j = numbers.length -1;
        for(;;) {
            if(numbers[i] + numbers[j] < target) {
                i++;
            } else if(numbers[i] + numbers[j] > target) {
                j--;
            } else {
               return new int[]{i,j}; 
            }
        }
    }

    public static void main(String[] args) {
        Solution tester = new Solution();
        int[] rlt = tester.twoSum(new int[]{1,2,4,6,10}, 8);
        for(int tmp : rlt) {
            System.out.println(tmp);
        }
        
    }
    
}
