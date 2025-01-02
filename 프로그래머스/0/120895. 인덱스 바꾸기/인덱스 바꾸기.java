class Solution {
    public String solution(String my_string, int num1, int num2) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < my_string.length() ; i++)
        {
            int idx = i;
            if(idx == num1)
                idx = num2;
            else if(idx == num2)
                idx = num1;
            sb.append(my_string.charAt(idx));
        }
        return sb.toString();
    }
}