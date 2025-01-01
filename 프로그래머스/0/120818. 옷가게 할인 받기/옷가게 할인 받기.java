class Solution {
    public int solution(int price) {
        double rate;
        if(price >= 500000)
            rate = 0.2;
        else if(price >= 300000)
            rate = 0.1;
        else if(price >= 100000)
            rate = 0.05;
        else
            rate = 0;
        return (int)((double)price * (1.00-rate));
    }
}