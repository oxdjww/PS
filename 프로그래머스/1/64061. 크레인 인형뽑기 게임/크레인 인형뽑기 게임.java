import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        List<Stack<Integer>> list = new ArrayList<>();
        Stack<Integer> basket = new Stack<>();
        
        for(int i = 0 ; i < board.length ; i++)
        {
            list.add(new Stack<Integer>());
        }
        
        for(int i = 0 ; i < board.length ; i++)
        {
            for(int j = board.length - 1 ; j >= 0 ; j--)
            {
                
                if(board[j][i] != 0)
                {
                    list.get(i).push(board[j][i]);
                }
            }
        }
        int answer = 0;
        for(int i = 0 ; i < moves.length ; i++)
        {
            Stack<Integer> currentStack = list.get(moves[i] - 1);
            if(!currentStack.isEmpty())
            {
                int top = currentStack.pop();
                if(!basket.isEmpty() && top == basket.peek())
                {
                    basket.pop();
                    answer+=2;
                }
                else
                {
                    basket.push(top);
                }
            }
        }
        return answer;
    }
}