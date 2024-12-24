import java.util.stream.*;
class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        for(char idx = 'A' ; idx <= 'Z' ; idx++)
        {
            Character charIdx = idx;
            answer[(int)idx - 'A'] = (int)my_string.chars()
                .filter(ch -> ch == charIdx)
                .count();
        }
        for(char idx = 'a' ; idx <= 'z' ; idx++)
        {
            Character charIdx = idx;
            answer[(int)idx - 71] = (int)my_string.chars()
                .filter(ch -> ch == charIdx)
                .count();
        }
        return answer;
    }
}