import java.util.*;
import java.util.stream.*;
class Solution {
    public String[] solution(String[] picture, int k) {
        List<String> answer = new ArrayList<>();
        for(int i = 0 ; i < picture.length ; i++)
        {
            StringBuilder sb = new StringBuilder();
            for(char ch : picture[i].toCharArray())
            {
                for (int ii = 0; ii < k; ii++) {
                    sb.append(ch);
                }
            }
            for(int ii = 0 ; ii < k ; ii++)
            {
                answer.add(sb.toString());
            }
        }
        return answer.stream()
            .toArray(String[]::new);
    }
}