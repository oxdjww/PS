import java.util.*;

class Solution {
    
    private static int n;
    private static Map<String, List<String>> db = new HashMap<>();
    private static List<String> answer = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {       
        // 티켓 저장
        n = (1 + tickets.length);
        
        for(int i = 0; i < tickets.length; i++) {
            String src = tickets[i][0];
            String dst = tickets[i][1];
            db.computeIfAbsent(src, k -> new ArrayList<>()).add(dst);
        }
        
        
        // 모든 티켓 알파벳 순서로 정렬
        for (String key : db.keySet()) {
            Collections.sort(db.get(key));
        }
        
        answer.add("ICN");
        dfs("ICN");
        
        String[] answerArray = new String[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
            answerArray[i] = answer.get(i);
        }
        return answerArray;
    }
    
    private static boolean dfs(String current) {
        if (answer.size() >= n) return true;

        if (!db.containsKey(current)) return false;

        List<String> destList = db.get(current);

        for (int i = 0; i < destList.size(); i++) {
            String next = destList.get(i);
            destList.remove(i);
            answer.add(next);

            if (dfs(next)) return true;

            // 백트래킹
            answer.remove(answer.size() - 1);
            destList.add(i, next);
        }

        return false;
    }
}