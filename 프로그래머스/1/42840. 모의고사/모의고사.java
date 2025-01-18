import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0 ; i < answers.length ; i++)
        {
            if(p1[i%p1.length] == answers[i])
                hm.put("p1", hm.getOrDefault("p1", 0) + 1);
        }
        for(int i = 0 ; i < answers.length ; i++)
        {
            if(p2[i%p2.length] == answers[i])
                hm.put("p2", hm.getOrDefault("p2", 0) + 1);
        }
        for(int i = 0 ; i < answers.length ; i++)
        {
            if(p3[i%p3.length] == answers[i])
                hm.put("p3", hm.getOrDefault("p3", 0) + 1);
        }
        int maxScore = 0;
        for(int score : hm.values())
        {
            if(score > maxScore)
                maxScore = score;
        }
        
        if(hm.getOrDefault("p1", 0) == maxScore) answer.add(1);
        if(hm.getOrDefault("p2", 0) == maxScore) answer.add(2);
        if(hm.getOrDefault("p3", 0) == maxScore) answer.add(3);
        
        int[] result = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
}