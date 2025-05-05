import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> types = new HashSet<>();
        for(int i = 0; i < gems.length; i++) {
            types.add(gems[i]);
        }
        Map<String, Integer> hm = new HashMap<>();
        
        int left = 0;
        int right = 0;
        int answerLeft = 0;
        int answerRight = 0;
        int answerLength = Integer.MAX_VALUE;
        
        while(right < gems.length) {
            hm.put(gems[right], hm.getOrDefault(gems[right], 0) + 1);
            right++;
            
            while(hm.size() == types.size()) {
                if(right - left + 1 < answerLength) {
                    answerLength = right - left + 1;
                    answerLeft = left;
                    answerRight = right - 1;
                }
                
                hm.put(gems[left], hm.get(gems[left]) - 1);
                if (hm.get(gems[left]) == 0) {
                    hm.remove(gems[left]);
                }
                left++;
            }
        }
        
        return new int[]{answerLeft+1, answerRight+1};
    }
}