public class Solution {
    public int[] countBits_old(int num) {
        int[] rltList = new int[num + 1];
        rltList[0] = 0;

        for(int i=1;i<=num;i++) {
            System.out.println(Integer.toBinaryString(i));
            rltList[i] = Integer.bitCount(i);
        }

        return rltList;
    }

    public int[] countBits(int num) {
        int[] rltList = new int[num + 1];
        rltList[0] = 0;
        int cnt = 1;
        int tmp = 0;
        for(int i=1;i<=num;i++) {
            tmp++;
            rltList[i] = 1 + rltList[i - cnt];
            if(tmp == cnt) {
                cnt = cnt << 1;
                tmp = 0;
            }
        }

        return rltList;
    }

    public static void printList(int[] rltList) {
        for(int tmp : rltList) {
            System.out.printf("%d,", tmp);
        }

        System.out.println("");
    }

    public static void main(String[] args) {
        Solution ins = new Solution();

        // printList(ins.countBits(2));
        printList(ins.countBits(15));
    }
}
