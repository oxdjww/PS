class Solution {
    public String solution(String my_string) {
        String answer = "";
        for(char ch : my_string.toCharArray())
        {
            if(ch >= 'a' && ch <= 'z')
            {
                answer += String.valueOf(ch).toUpperCase();
            }else{
                answer += String.valueOf(ch).toLowerCase();
            }
        }
        return answer;
    }
}