class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int child = numer1 * denom2 + numer2 * denom1;
        int parent = denom1 * denom2;
        for(int i = child-1 ; i > 0 ; i--)
        {
            if(child % i == 0 && parent % i == 0)
            {
                child /= i;
                parent /=i;
            }
        }
        return new int[]{child, parent};
    }
}