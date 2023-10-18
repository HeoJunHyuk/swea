package swea.D2;

import java.io.IOException;
import java.util.Scanner;

// 두 개의 숫자열
// 풀이: N>M, N<M, N=M 나눠서 A[],B[]의 인덱스 곱을 진행 후, sum에 저장하여 max값을 찾음.
public class Solution1959 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] A = new int[N];
            int[] B = new int[M];
            int sum = 0;
            int max = 0;

            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            for (int i = 0; i < M; i++) {
                B[i] = sc.nextInt();
            }
            if (N > M) {    // A[] > B[]
                for (int i = 0; i < N - M + 1; i++) {
                    for (int j = 0; j < B.length; j++) {
                        sum += A[i + j] * B[j];
                    }
                    max = Math.max(max, sum);
                    sum = 0;
                }
            } else {    // B[] > A[]
                for (int i = 0; i < M - N + 1; i++) {
                    for (int j = 0; j < A.length; j++) {
                        sum += A[j] * B[i + j];
                    }
                    max = Math.max(max, sum);
                    sum = 0;
                }
            }
            // N = M 일때도 생각해야함.
            System.out.println("#" + tc + " " + max);
        }
        sc.close();
    }
}
