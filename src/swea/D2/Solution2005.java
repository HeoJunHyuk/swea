package swea.D2;

import java.io.IOException;
import java.util.Scanner;

// 파스칼의 삼각형
// 풀이 : 2차원 배열 사용 -> 2중 for문 사용해서 [i-1][j-1] + [i-1][j] = [i][j]
public class Solution2005 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();   // 1

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();   // 4
            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    if (i == j || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                    }
                }
            }
            System.out.printf("#%d\n", tc);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}
