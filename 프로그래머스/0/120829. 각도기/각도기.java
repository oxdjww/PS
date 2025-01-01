class Solution {
    public int solution(int angle) {
        return angle/90 == 2 ? 4 :(angle/90 == 1 ? (angle%90 > 0 ? 3 : 2 ) : 1);
    }
}