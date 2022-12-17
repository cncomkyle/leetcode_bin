import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    class DisEntry {
        int preIdx1;
        int preIdx2;
        int preDis;

        public DisEntry(int preIdx1, int preIdx2, int preDis) {
            this.preIdx1 = preIdx1;
            this.preIdx2 = preIdx2;
            this.preDis = preDis;
        }

        public String toString() {
            return this.preIdx1 + ":" + this.preIdx2 + ":" + this.preDis;
        }
    }
    
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();

        if(length1 == 0
           || length2 == 0) {
            return Math.max(length1, length2);
        }

        int min = Math.max(length1, length2);
        Map<String, List<Integer>> charMap = new HashMap<String, List<Integer>>();
        for(int i=1;i<=word1.length();i++) {
            String tmpIdx = word1.substring(i-1, i);
            if(charMap.get(tmpIdx) == null) {
                charMap.put(tmpIdx, new ArrayList<Integer>());
            }

            charMap.get(tmpIdx).add(i);
        }
        //System.out.println(charMap);

        List<DisEntry> disEntryList = new ArrayList<DisEntry>();
        disEntryList.add(new DisEntry(0, 0, 0));

        for(int i=1;i<=word2.length();i++) {
            List tmpMap = charMap.get(word2.substring(i-1, i));
            if(tmpMap == null) {
                continue;
            }
            DisEntry[] preEntryList = (DisEntry[])disEntryList.toArray(new DisEntry[disEntryList.size()]);

            for(int k =0;k<tmpMap.size();k++) {
                Integer tmpIdx = (Integer)tmpMap.get(k);
                for(DisEntry preEntry : preEntryList) {
                    if(tmpIdx <= preEntry.preIdx1) {
                        continue;
                    }
                    int tmpDis = Math.max(tmpIdx - preEntry.preIdx1 -1, i - preEntry.preIdx2 - 1);
                    if(tmpDis > min) {
                        continue;
                    }
                    DisEntry newEntry = new DisEntry(tmpIdx, i, preEntry.preDis +  tmpDis);
                    disEntryList.add(newEntry);
                }
            }
            //System.out.println(disEntryList);
        }

        //System.out.println("last compare:");
        for(DisEntry tmpEntry : disEntryList) {
            tmpEntry.preDis = tmpEntry.preDis + Math.max(length1  - tmpEntry.preIdx1 , length2  - tmpEntry.preIdx2 );
            //System.out.printf("%d:%d:%d\n",tmpEntry.preIdx1, tmpEntry.preIdx2, tmpEntry.preDis);
            min =Math.min(min, tmpEntry.preDis);
        }

        return min;
    }

    public static void main(String[] args) {
        Solution ins = new Solution();
        System.out.println(ins.minDistance("horse", "ros"));
        System.out.println(ins.minDistance("intention", "execution"));
        System.out.println(ins.minDistance("pneumonoultramicroscopicsilicovolcanoconiosis","ultramicroscopical"));
    }
}
