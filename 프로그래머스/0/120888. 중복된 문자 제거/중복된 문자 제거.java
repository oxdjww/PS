import java.util.*;
class Solution {
    public String solution(String my_string) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char ch : my_string.toCharArray()) {
            set.add(ch);
        }
        StringBuilder answer = new StringBuilder();
        for (char ch : set) {
            answer.append(ch);
        }
        return answer.toString();
    }
}
