package swea.D3;

import java.util.Scanner;

// [Professional] 조합 ******
// 풀이: 이항계수로 풀 수 없고, MOD연산은 나눗셈에는 적용 못함. 때문에 분모에 있는 a를 a^-1로 바꾼 뒤, 페르마 소정리 이용 -> 페르마의 소정리 :  a^p-2 = a^-1 ( p는 MOD, a는 r!(n-r)! )

public class Solution5607 {

    static long MOD = 1234567891;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int R = sc.nextInt();
            long[] factorial = new long[N + 1];

            factorial[0] = 1;
            for (int i = 1; i <= N; i++) {  // 팩토리얼 설정
                factorial[i] = (factorial[i - 1] * i) % MOD;
            }

            long top = factorial[N];
            long bottom = (factorial[R] * factorial[N - R]) % MOD;
            long rebottom = calculatePow(bottom, MOD - 2);
            long result = top * rebottom % MOD;


            System.out.println("#" + tc + " " + result);
        }
    }

    //분할 정복으로 해결
    private static long calculatePow(long N, long R) {
        if (R == 1) {
            return N;
        }
        long x = calculatePow(N, R / 2);
        if (R % 2 == 0) {
            return (x * x) % MOD;
        } else return ((x * x) % MOD * N) % MOD;
    }
}
