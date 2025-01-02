class Solution {
    public int solution(int n) {
        int answer = 0;
        int counter = 0;
        while(counter < n)
        {
            answer++;
            while(answer%3 == 0 || String.valueOf(answer).contains("3")){
                answer++;
            }
            counter++;
        }
        return answer;
    }
}