class Solution {
    public int numJewelsInStones(String J, String S) {
        int tmp_Upper = 0;
        int tmp_Lower = 0;

        int result = 0;
        for(char tmpChar : J.toCharArray()) {
            if(tmpChar >= 'a' && tmpChar <= 'z') {
                tmp_Lower |= 1 << (tmpChar - 'a');
            } else {
                tmp_Upper |= 1 << (tmpChar - 'A');
            }
        }

        for(char tmpChar : S.toCharArray()) {
            if(tmpChar >= 'a' && tmpChar <= 'z'
               && (tmp_Lower & 1 << (tmpChar - 'a')) > 0) {
                result ++;
            } else if(tmpChar >= 'A' && tmpChar <= 'Z'
               &&(tmp_Upper & 1 << (tmpChar - 'A')) > 0) {
                result++;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Solution instance = new Solution();
        System.out.println(instance.numJewelsInStones("WKD", "kmHbs"));
    }
}

    
