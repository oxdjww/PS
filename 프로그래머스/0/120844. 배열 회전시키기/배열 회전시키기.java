class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        int start = 0;
        if(direction.length() == 5)
        {
            start = numbers.length-1;
        }else{
            start = 1;
        }
        int idx = 0;
        for(int i = start ; idx < numbers.length ; i++)
        {
            if(i < 0 || i >= numbers.length)
                i %= numbers.length;
            answer[idx++] = numbers[i];
        }
        return answer;
    }
}