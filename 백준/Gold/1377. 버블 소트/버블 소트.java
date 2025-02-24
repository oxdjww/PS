import java.io.*;
import java.util.*;

public class Main {
    private static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < N ; i++)
        {
            list.add(new int[]{i, Integer.parseInt(br.readLine())});
        }

        list.sort((arr1, arr2) -> {
            if(arr1[1] == arr2[1])
            {
                return Integer.compare(arr1[0], arr2[0]);
            }
            else
            {
                return Integer.compare(arr1[1], arr2[1]);
            }
        });

        int max = 0;
        for(int i = 0 ; i < N ; i++)
        {
            if(max < list.get(i)[0] - i)
                max = list.get(i)[0] - i;
        }
        System.out.print(max+1);
    }
}