class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int hp = health;
        
        int timer = 0;
        int healTime = bandage[0];
        int healPlusPerSec = bandage[1];
        int healBonus = bandage[2];
        
        int monsterIndex = 0;
        
        for(int currentTime = 0; currentTime <= attacks[attacks.length-1][0]; currentTime++) {
            if(currentTime == attacks[monsterIndex][0]) {
                hp -= attacks[monsterIndex][1];
                if(hp < 0) {
                    return -1;
                }
                monsterIndex++;
                timer = 0;
            } else {
                hp += healPlusPerSec;
                
                timer++;
                
                if(timer == healTime) {
                    hp += healBonus;
                    timer = 0;
                }
            }
            
            if(hp > health) {
                hp = health;
            }
            // System.out.println("time: " + currentTime + ", hp: " + hp);
        }
        
        return hp > 0 ? hp : -1;
    }
}