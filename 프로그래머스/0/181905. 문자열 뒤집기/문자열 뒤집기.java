class Solution {
    public String solution(String my_string, int s, int e) {
        String mid = new StringBuilder(my_string.substring(s, e + 1)).reverse().toString();
        String start = my_string.substring(0, s);
        String end = my_string.substring(e + 1, my_string.length());
        return new StringBuilder().append(start).append(mid).append(end).toString();
    }
}