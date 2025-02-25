import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Integer[] arr = new Integer[str.length()];

        for(int i = 0 ; i < str.length() ; i++)
        {
            arr[i] = str.charAt(i) - '0';
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for(int i = 0 ; i < arr.length ; i++)
        {
            sb.append(arr[i]);
        }
        System.out.print(sb);
    }
}