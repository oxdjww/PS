class Solution {
    public String solution(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < str1.length()*2; i++)
        {
            sb.append(i%2==0 ? str1.charAt(i/2) : str2.charAt(i/2));
        }
        return sb.toString();
    }
}