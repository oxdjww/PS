import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] array) {
        int[] answer = new int[1000];
        for(int val : array)
        {
            answer[val]++;
        }
        List<Integer> answerList = Arrays.stream(answer).boxed().collect(Collectors.toList()); 
        int max = Collections.max(answerList);
        int maxCnt = 0;
        for(int val : answer)
        {
            if(val == max)
                maxCnt++;
        }
        return maxCnt > 1 ? -1 : answerList.indexOf(max);
    }
}