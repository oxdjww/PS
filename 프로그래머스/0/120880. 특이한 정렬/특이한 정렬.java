import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        List<Number> list = new ArrayList<>();
        for(int i = 0 ; i < numlist.length ; i++)
        {
            list.add(
                new Number(numlist[i], Math.abs(n-numlist[i]))
            );
        }
        Collections.sort(list);
        return list.stream()
            .map(Number::getNumber)
            .mapToInt(idx -> (int)idx)
            .toArray();
    }
}
class Number implements Comparable<Number>{
    private int value;
    private int distance;
    
    Number(int value, int distance)
    {
        this.value = value;
        this.distance = distance;
    }
    
    int getNumber(){
        return this.value;
    }
    
    @Override
    public int compareTo(Number number)
    {
        if(this.distance > number.distance)
            return 1;
        if(this.distance == number.distance)
        {
            if(this.value < number.value)
                return 1;
            else return -1;
        }
        if(this.distance < number.distance)
            return -1;
        return 0;
    }
}