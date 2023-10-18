package swea.D2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// 어디에 단어가 들어갈 수 있을까
// 풀이: 행, 열을 나누어서 비교, 2중 for, if 활용하여 cnt, result 변수 사용
public class Solution1979 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int result = 0;
            int[][] puzzle = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    puzzle[i][j] = sc.nextInt();
                }
            }

            //행(가로)
            for (int i = 0; i < N; i++) {
                int cnt = 0;
                for (int j = 0; j < N; j++) {
                    if (puzzle[i][j] == 0) {
                        if (cnt == K) {
                            result += 1;
                        }
                        cnt = 0;
                    } else cnt++;
                }
                if (cnt == K) {
                    result += 1;
                }
            }

            //열(세로)
            for (int j = 0; j < N; j++) {
                int cnt = 0;
                for (int i = 0; i < N; i++) {
                    if (puzzle[i][j] == 0) {
                        if (cnt == K) {
                            result += 1;
                        }
                        cnt = 0;
                    } else cnt++;
                }
                if (cnt == K) {
                    result += 1;
                }
            }
            System.out.println("#" + tc + " " + result);

        }
    }
}
