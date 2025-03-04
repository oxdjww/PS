import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int XL = Integer.parseInt(st.nextToken());
        int XXL = Integer.parseInt(st.nextToken());
        int XXXL = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int shirtsCount = S % T == 0 ? S / T : S / T + 1;
        shirtsCount += M % T == 0 ? M / T : M / T + 1;
        shirtsCount += L % T == 0 ? L / T : L / T + 1;
        shirtsCount += XL % T == 0 ? XL / T : XL / T + 1;
        shirtsCount += XXL % T == 0 ? XXL / T : XXL / T + 1;
        shirtsCount += XXXL % T == 0 ? XXXL / T : XXXL / T + 1;

        System.out.println(shirtsCount);
        System.out.println(N/P + " " + N%P);
    }
}