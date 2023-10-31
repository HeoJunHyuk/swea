package swea.D3;

import java.util.Scanner;

// [Professional] 조합
// 풀이:

public class Solution5607 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            long N = sc.nextInt();
            long R = sc.nextInt();
            long a = 1;
            long b = 1;
            long result = 0;

            if (R > N / 2) {
                for (long i = N; i > N - (N - R); i--) {
                    a *= i;
                }
                for (long i = N - R; i > 0; i--) {
                    b *= i;
                }
            } else
            {
                for (long i = N; i > N - R; i--) {
                    a *= i;
                }
                for (long i = R; i > 0; i--) {
                    b *= i;
                }
            }

            result = (a / b) % 1234567891;
            System.out.println("#" + tc + " " + result);
        }
    }
}
