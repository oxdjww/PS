import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> numbers = new Stack<>();
        for(int value : arr)
        {
            if(!numbers.empty() && value == numbers.peek())
            {
                continue;
            }
            numbers.push(value);
        }
        List<Integer> answer = new ArrayList<>(numbers);
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}