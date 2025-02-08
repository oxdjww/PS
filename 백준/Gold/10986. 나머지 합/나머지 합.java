import java.io.*;
import java.util.*;

public class Main {
    private static int N,M;
    private static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());

        arr = new long[N];

        long answer = 0;

        for(int i = 0; i < N ; i++)
        {
            long value = (i == 0 ? 0 : arr[i-1]) + Long.parseLong(st.nextToken());
            // 이미 0~i번쨰 인덱스 까지의 구간합이 M으로 나눈 나머지가 0인 경우
            if(value % M == 0) answer++;
            arr[i] = value;
        }
        // case: i <= j
        // (arr[j] - arr[i]) % M = 0 인 상황을 구해야 함
        // (arr[j] - arr[i]) % M = arr[j] % M - arr[i] % M = 0
        // arr[j] % M = arr[i] % M 인 경우를 구하면 되지 않을까

        // M으로 나누니까 나머지는 0~M-1까지 가능
        long[] count = new long[M];

        long[] remainder = new long[N];

        for(int i = 0 ; i < N ; i++)
        {
            remainder[i] = arr[i] % M;
            count[(int)remainder[i]]++;
        }
        
        // count 배열에 각 나머지를 가지는 인덱스의 개수가 저장됨
        // 그 중에 두개 뽑아서 구간 만들면 되니까.
        for(int i = 0 ; i < M ; i++)
        {
            if(count[i] > 1)
            {
                answer += (count[i] * (count[i]-1) / 2);
            }
        }
        System.out.println(answer);
    }
}