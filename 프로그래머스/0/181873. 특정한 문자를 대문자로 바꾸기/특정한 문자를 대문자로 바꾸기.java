class Solution {
    public String solution(String my_string, String alp) {
        String answer = "";
        char[] arr = my_string.toCharArray();
        char alpChar = alp.charAt(0);
        for (int i =0  ; i < arr.length ; i++)
        {
            answer += (arr[i] == alpChar ? (char)((int)alpChar-32) : arr[i]);
        }
        return answer;
    }
}