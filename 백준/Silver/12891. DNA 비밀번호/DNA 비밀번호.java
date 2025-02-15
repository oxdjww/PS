import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] cond = new int[4];
    private static int valid = 0;
    private static int[] cur = new int[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dnaLength = Integer.parseInt(st.nextToken());
        int subLength = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String dnaStr = st.nextToken();

        st = new StringTokenizer(br.readLine());
        cond[0] = Integer.parseInt(st.nextToken());
        if(cond[0] == 0) valid++;
        cond[1] = Integer.parseInt(st.nextToken());
        if(cond[1] == 0) valid++;
        cond[2] = Integer.parseInt(st.nextToken());
        if(cond[2] == 0) valid++;
        cond[3] = Integer.parseInt(st.nextToken());
        if(cond[3] == 0) valid++;

        int count = 0;
        int start = 0;
        int end = subLength;
        
        for(int i = start ; i < end ; i++)
        {
            if(dnaStr.charAt(i) == 'A') cur[0]++;
            if(dnaStr.charAt(i) == 'C') cur[1]++;
            if(dnaStr.charAt(i) == 'G') cur[2]++;
            if(dnaStr.charAt(i) == 'T') cur[3]++;
        }

        if(check())
            count++;
        
        for(int i = subLength ; i < dnaLength ; i++)
        {
            start = i - subLength;

            if(dnaStr.charAt(start) == 'A') cur[0]--;
            if(dnaStr.charAt(start) == 'C') cur[1]--;
            if(dnaStr.charAt(start) == 'G') cur[2]--;
            if(dnaStr.charAt(start) == 'T') cur[3]--;

            if(dnaStr.charAt(i) == 'A') cur[0]++;
            if(dnaStr.charAt(i) == 'C') cur[1]++;
            if(dnaStr.charAt(i) == 'G') cur[2]++;
            if(dnaStr.charAt(i) == 'T') cur[3]++;
            if(check())
                count++;
        }

        System.out.println(count);
    }
    private static boolean check() {
		for (int i = 0 ; i < 4 ; i++)
        {
			if (cur[i] < cond[i])
				return false;
		}
		return true;
	}
}