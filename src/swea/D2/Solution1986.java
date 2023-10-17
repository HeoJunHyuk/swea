package swea.D2;

import java.io.IOException;
import java.util.Scanner;

// 지그재그 숫자
// 풀이: 짝수,홀수 -> 덧셈,뺄셈
public class Solution1986 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int sum = 0;

            for (int i = 1; i <= N; i++) {
                if (i % 2 == 1) {
                    sum += i;
                } else {
                    sum -= i;
                }
            }
            System.out.printf("#%d %d\n", tc, sum);
        }
    }
}
