class Solution2 {
    public int trap(int[] height) {
        int sum = 0;
        if(height.length == 0) {
            return sum;
        }
        int begin = 0, end = begin + 1;
        int intervalSum = 0;
        int lastValid = 0;
        while(end < height.length) {
            if(height[begin] == 0) {
                begin++;
                end=begin + 1;
                continue;
            }

            lastValid = end;
            if(height[end] < height[begin]) {
                intervalSum+=height[end++];
            } else { // >=
                if(end - begin == 1) {
                    begin++;
                    end = begin+1;
                    continue;
                } else {
                    System.out.printf("begin:%d#end:%d#intervalSum:%d#sum:%d#lastValid:%d\n", begin, end, intervalSum, sum, lastValid);
                    sum+=(height[begin] * (end - begin -1) - intervalSum);
                    intervalSum = 0;
                    begin = end;
                    end = begin + 1;
                    lastValid = 0;
                }
            }
        }

        System.out.printf("lastValid:%d\n", lastValid);
        if(lastValid > 0) {
            if(lastValid - begin > 1) {
                int newBegin = lastValid;
                int newEnd = newBegin - 1;
                intervalSum = 0;
                while(newEnd >= begin) {
                    if(height[newBegin] == 0) {
                        newBegin--;
                        newEnd = newBegin - 1;
                        continue;
                    }

                    if(height[newEnd] < height[newBegin]) {
                        intervalSum+=height[newEnd--];
                    } else {
                        if(newBegin - newEnd == 1) {
                            newBegin--;
                            newEnd = newBegin - 1;
                            continue;
                        } else {
                            System.out.printf("last:begin:%d#end:%d#intervalSum:%d#sum:%d\n", newBegin, newEnd, intervalSum, sum, lastValid);
                            sum+=(height[newBegin] * (newBegin - newEnd - 1) - intervalSum);
                            intervalSum = 0;
                            newBegin = newEnd;
                            newEnd = newBegin - 1;
                        }
                    }
                }
                
            }
        }
        
        return sum;
    }

    public static void main(String[] args) {
        Solution2 ins = new Solution2();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        height = new int[]{4, 2, 3};
        System.out.println(ins.trap(height));
    }
}
