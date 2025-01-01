class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        while(age/10 > 0)
        {
            sb.append(String.valueOf((char)(age % 10 + 97)));
            age /= 10;
        }
        sb.append(String.valueOf((char)(age % 10 + 97)));
        return sb.reverse().toString();
    }
}