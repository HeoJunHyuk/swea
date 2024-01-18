package backjoon.Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 설탕 배달 [silver 4]
// 풀이 : 3kg, 5kg 봉투에 담을 때 봉투 최소 갯수 -> 5로 나눌 수 있으면 그게 정답, 안된다면 N - 3을 계속 해주면서 0이 될 때까지 진행. 1,2가 남게 되면 안나눠지므로 -1
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
