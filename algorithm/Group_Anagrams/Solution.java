import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public String getKey(String str) {
        int[] tmpMap = new int[26];
        char[] chars = str.toCharArray();
        for(char tmpChar : chars) {
            tmpMap[tmpChar-'a']++;
        }
        return new String(tmpMap, 0, 26);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> rltList = new ArrayList<List<String>>();
        if(strs.length == 0) {
            return rltList;
        }
        Map<String, List<String>> mapList = new HashMap<String, List<String>>();

        for(String tmpStr : strs) {
            String keyStr = getKey(tmpStr);
            if(mapList.containsKey(keyStr)) {
                mapList.get(keyStr).add(tmpStr);
            } else {
                List<String> newList = new ArrayList<String>();
                newList.add(tmpStr);
                mapList.put(keyStr, newList);
            }
        }

        for(List<String> tmpList : mapList.values()) {
            rltList.add(tmpList);
        }

        return rltList;
    }

    public static void main(String[] args) {
        Solution ins = new Solution();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> rltList = ins.groupAnagrams(strs);
        for(List<String> tmpList : rltList) {
            for(String tmpStr : tmpList) {
                System.out.printf("%s,",tmpStr);
            }
            System.out.printf("\n");
        }
    }
}
