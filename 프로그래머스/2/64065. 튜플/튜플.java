import java.util.*;

class Solution {
    public int[] solution(String s) {
        HashMap<String, Integer> db = new HashMap<>();
        s = s.replace("{", "").replace("}", "");
        String[] arr = s.split(",");
        for(String str: arr)
        {
            db.put(str, db.getOrDefault(str, 0) + 1);
        }
        
        for(Map.Entry<String, Integer> entry: db.entrySet())
        {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(db.entrySet());
        list.sort((entry1, entry2) -> entry2.getValue() - entry1.getValue());

        int[] sortedKeys = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            sortedKeys[i] = Integer.parseInt(list.get(i).getKey());
        }

        return sortedKeys;
    }
}