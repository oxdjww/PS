class Solution {
    public int solution(int chicken) {
        int coupon = chicken;
        int serviceCount = 0;
        do
        {
            int serviceOrder = coupon/10;
            serviceCount += serviceOrder;
            coupon = coupon % 10 + serviceOrder;
        }while(coupon >= 10);
        return serviceCount;
    }
}