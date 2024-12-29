import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(String[] strArr) {
        List<String> strList = Arrays.stream(strArr)
            .collect(Collectors.toList());
        List<Integer> answer = new ArrayList<>(Collections.nCopies(31, 0));
        for(int i = 0 ; i < strList.size() ; i++)
        {
            int idx = strList.get(i).length();
            answer.set(idx, answer.get(idx)+1);
        }
        return Collections.max(answer);
    }
}