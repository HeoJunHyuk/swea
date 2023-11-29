package backjoon.Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int cnt = 0;
        while (N > 0) {
            if (N % 5 == 0) {
                cnt += N / 5;
                System.out.println(cnt);
                return;
            }
            if (N < 3) {
                System.out.println(-1);
                return;
            }
            N -= 3;
            cnt++;
        }
        System.out.println(cnt);
        br.close();
    }
}
