package swea.D3;

import java.util.Scanner;

// 농작물 수확하기
// 풀이:
public class Solution2805 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
           int N = sc.nextInt();
           int[][] field = new int[N][N];
           int sum = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    field[i][j] = sc.nextInt();
                    if (i == N / 2 || j == N /2) {
                        sum += field[i][j];
                    }
                }
            }


        }
    }
}
