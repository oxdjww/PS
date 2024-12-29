import java.util.stream.*;
class Solution {
    public String solution(String myString) {
        return myString.chars()
            .map(ch -> ch - 'l' < 0 ? 'l' : ch)
            .mapToObj(ch -> String.valueOf((char) ch))
            .collect(Collectors.joining());
    }
}