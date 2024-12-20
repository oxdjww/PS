import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int l, int r) {
        List<Integer> answer = new ArrayList<>();
        for(int i = l ; i <= r ; i++)
        {
            String stringValue = Integer.toString(i);
            long correctCount = stringValue.chars()
                .filter(k -> k == '0' || k == '5')
                .count();
            if (correctCount == stringValue.length())
                answer.add(i);
        }
        int[] answerArray = answer.stream().mapToInt(i -> (int)i).toArray();
        return answerArray.length == 0 ? new int[]{-1} : answerArray;
    }
}