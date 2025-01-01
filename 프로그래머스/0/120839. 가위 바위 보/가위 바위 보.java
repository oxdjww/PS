class Solution {
    public String solution(String rsp) {
        String answer ="";
        for(String str : rsp.split(""))
        {
            answer += Integer.parseInt(str) > 0 ? (Integer.parseInt(str) == 2 ? 0 : 2) : 5;
        }
        return answer;
    }
}