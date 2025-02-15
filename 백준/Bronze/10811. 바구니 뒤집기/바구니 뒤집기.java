import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int[] baskets = new int[N];
        for (int i = 0; i < N; i++)
        {
            baskets[i] = i + 1;
        }
        
        for (int k = 0; k < M; k++)
        {
            int i = sc.nextInt();
            int j = sc.nextInt();
            
            reverse(baskets, i - 1, j - 1);
        }
        
        for (int i = 0; i < N; i++)
        {
            System.out.print(baskets[i] + " ");
        }
    }
    
    public static void reverse(int[] baskets, int start, int end)
    {
        while (start < end)
        {
            int temp = baskets[start];
            baskets[start] = baskets[end];
            baskets[end] = temp;
            start++;
            end--;
        }
    }
}
