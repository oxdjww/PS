import java.util.*;
class Solution {
    public String[] solution(String myStr) {
        String[] splitArray = myStr.split("[abc]+");
        
        String[] result = Arrays.stream(splitArray)
                                .filter(s -> !s.isEmpty())
                                .toArray(String[]::new);
        return result.length == 0 ? new String[]{"EMPTY"} : result;
    }
}