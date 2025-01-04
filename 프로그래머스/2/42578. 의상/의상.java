import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (String[] cloth : clothes) {
            String category = cloth[1];
            hm.put(category, hm.getOrDefault(category, 0) + 1);
        }
        
        int combination = 1;
        for(int categoryCount : hm.values())
        {
            combination *= (categoryCount + 1);
        }
        
        return combination-1;
    }
}