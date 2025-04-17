class Solution {
    private static StringBuilder sb = new StringBuilder();
    private static String[] alpha = new String[]{"A", "E", "I", "O", "U"};
    private static String findWord;
    private static int depth = 0;
    public int solution(String word) {
        findWord = word;
        
        if (dfs(alpha[0] , 1)) return depth;
        if (dfs(alpha[1] , 1)) return depth;
        if (dfs(alpha[2] , 1)) return depth;
        if (dfs(alpha[3] , 1)) return depth;
        if (dfs(alpha[4] , 1)) return depth;
        
        return depth;
    }
    
    private static boolean dfs(String current, int index) {
        depth++;
        // System.out.println("DEPTH: " + depth + "CURRENT: " + current);
        if(current.equals(findWord)) {
            return true;
        }
        if(index == 5) return false;
        for(int i = 0; i < alpha.length; i++) {
            current = current.concat(alpha[i]);
            if(dfs(current, index + 1)) {
                return true;
            }
            current = current.substring(0, current.length() - 1);
        }
        return false;
    }
}