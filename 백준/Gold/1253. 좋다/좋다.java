import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;
        
        
        for(int i = 0 ; i < N ; i++)
        {
            int find = arr[i];
            int start = 0;
            int end = N-1;

            while(start < end)
            {
                if(arr[start] + arr[end] > find)
                {
                    end--;
                }
                else if(arr[start] + arr[end] < find)
                {
                    start++;
                }
                else
                {
                    if(start != i && end != i)
                    {
                        count++;
                        break;      
                    }
                    else if(start == i)
                    {
                        start++;
                    }
                    else if(end == i)
                    {
                        end--;
                    }
                }
            }
        }
        System.out.println(count);
    }
}