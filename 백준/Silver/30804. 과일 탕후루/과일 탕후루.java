import java.util.*;
import java.io.*;

public class Main {
    HashMap<String, Integer> db = new HashMap<>();
    Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++)
        {
            int input = scanner.nextInt();
            arr[i] = input;
        }

        int typeCount = 0;
        int maxLength = 0;

        for(int left = 0, right = 0 ; right < n ; right++)
        {
            if(count[arr[right]] == 0) typeCount++;
            count[arr[right]]++;

            while(typeCount > 2)
            {
                count[arr[left]]--;
                if(count[arr[left]] == 0) typeCount--;
                left += 1;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.print(maxLength);
    }
}
