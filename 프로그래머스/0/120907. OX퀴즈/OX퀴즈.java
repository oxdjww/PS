import java.util.*;
import java.util.stream.*;
class Solution {
    public String[] solution(String[] quiz) {
        List<String> answer = new ArrayList<>();
        for(String q : quiz)
        {
            String[] str = q.split(" ");
            int X = Integer.parseInt(str[0]);
            String oper = str[1];
            int Y = Integer.parseInt(str[2]);
            int Z = Integer.parseInt(str[4]);
            int result = oper.equals("+") ? X+Y : X-Y;
            answer.add(result == Z ? "O" : "X");
        }
        
        return answer.stream().toArray(String[]::new);
    }
}