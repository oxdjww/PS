import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(String part : participant)
        {
            hm.put(part, hm.getOrDefault(part, 0) + 1);
        }
        for(String comp : completion)
        {
            if(hm.get(comp) == 1)
                hm.remove(comp);
            else
                hm.put(comp, hm.get(comp) - 1);
            
        }
        return hm.entrySet().iterator().next().getKey();
    }
}