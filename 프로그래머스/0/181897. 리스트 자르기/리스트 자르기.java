import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        List<Integer> list = Arrays.stream(num_list)
            .boxed()
            .collect(Collectors.toList());
        List<Integer> answer = new ArrayList<>();
        switch(n){
            case 1:
                answer = list.subList(0,b+1);
                break;
            case 2:
                answer = list.subList(a,list.size());
                break;
            case 3:
                answer = list.subList(a,b+1);
                break;
            case 4:
                for(int i = a ; i < b+1 ; i +=c)
                {
                    answer.add(list.get(i));
                }
            default:
                break;
        }
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}