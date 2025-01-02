class Solution {
    double getSlope(int[] a, int[] b) {
            return (double) (a[1] - b[1]) / (a[0] - b[0]);
        }
    public int solution(int[][] dots) {

        if (getSlope(dots[0], dots[1]) == getSlope(dots[2], dots[3])) return 1;
        if (getSlope(dots[0], dots[2]) == getSlope(dots[1], dots[3])) return 1;
        if (getSlope(dots[0], dots[3]) == getSlope(dots[1], dots[2])) return 1;

        return 0;
    }
}
