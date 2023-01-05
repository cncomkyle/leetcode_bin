import java.util.*;

public class Solution692 {
    public List<String> topKFrequent_1(String[] words, int k) {
        
        List<String> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++)
        {
            if(map.containsKey(words[i]))
                map.put(words[i], map.get(words[i])+1);
            else
                map.put(words[i], 1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                 (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        );
        
        for(Map.Entry<String, Integer> entry: map.entrySet())
        {
            pq.offer(entry);
            if(pq.size()>k)
                pq.poll();
        }

        while(!pq.isEmpty())
            result.add(0, pq.poll().getKey());
        
        return result;
    }


    public List<String> topKFrequent(String[] words, int k) {
        List<String> rst = new ArrayList<>();
        if (words == null || words.length == 0) {
            return rst;
        }

        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(k,
                (a, b) -> a.getValue() != b.getValue() ? b.getValue() - a.getValue()
                        : a.getKey().compareTo(b.getKey()));
        for (Map.Entry<String, Integer> set : map.entrySet()) {
            maxHeap.add(set);
        }

        for(Map.Entry<String, Integer> entry : maxHeap) {
            System.out.printf("%s:%s\n", entry.getKey(), entry.getValue());
        }

        while (k > 0) {
            rst.add(maxHeap.poll().getKey());
            k--;
        }
        return rst;
    }

    public static void main(String[] args) {
        Solution692 tester = new Solution692();
        List<String> rltList = tester.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is", "is"}, 3);
        for(String rlt : rltList) {
            System.out.println(rlt);
        }

        System.out.println("is".compareTo("the"));
    }

}