import java.math.BigInteger;

class Solution {
    public int solution(int balls, int share) {
        BigInteger child = fact(balls);
        BigInteger parent = fact(balls - share).multiply(fact(share));
        return child.divide(parent).intValue();
    }
    
    private BigInteger fact(int n) {
        BigInteger res = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }
}
