import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr) {
        return IntStream.of(arr).map(n -> (n>= 50 && n%2==0 ? n/2
                                   : (n<50 && n%2==1)?n*2 :n ))
            .toArray();
    }
}