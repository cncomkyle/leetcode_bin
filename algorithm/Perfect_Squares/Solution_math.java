public class Solution_math {
    private boolean isSquare(int n) {
        int tmp = (int)Math.sqrt(n);
        return n == tmp * tmp;
    }
    
    public int numSquares(int n) {
        if(isSquare(n)) {
            return 1;
        }

        while((n&3) == 0) {
            n = n >> 2;
        }

        if((n&7) ==7) {
            return 4;
        }

        int tmp = (int)Math.sqrt(n);

        for(int i=1;i<=tmp;i++) {
            if(isSquare(n - i * i)) {
                return 2;
            }
        }

        return 3;
    }

    public static void main(String[] args) {
        Solution_math ins = new Solution_math();

        System.out.println(ins.numSquares(12));
        System.out.println(ins.numSquares(13));
    }
}
