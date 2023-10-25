package swea.D3;

import java.io.IOException;
import java.util.Scanner;

// [S/W 문제 해결 기본] 2일차 - Sum
// 풀이: 2차원 배열 행, 열, 오른쪽 대각선, 왼쪽 대각선 sum 값 비교 -> 오른쪽 대각선 : i == j , 왼쪽 대각선 : j == 99 - i
public class Solution1209 {

    static int[][] map;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int T = sc.nextInt();
            map = new int[100][100];
            int row;
            int col;
            int crossR = 0;
            int crossL = 0;
            int max = 0;

            for (int i = 0; i < 100; i++) {
                row = 0;

                // 행
                for (int j = 0; j < 100; j++) {
                    map[i][j] = sc.nextInt();
                    row += map[i][j];
                    if (i == j) {   // 오른쪽 대각선
                        crossR += map[i][j];
                    }
                }
                max = Math.max(row, max);
                }

            // 열
            for (int i = 0; i < 100; i++) {
                col = 0;

                for (int j = 0; j < 100; j++) {
                    col += map[j][i];
                    if (j == 99 - i) {
                        crossL += map[j][i];
                    }
                }
                max = Math.max(col, max);
            }

            max = Math.max(max, crossR);
            max = Math.max(max, crossL);
            System.out.println("#" + T + " " + max);

        }
    }

}
/**
 * for(int i =0; i<100; i++){
 *                 sum1 = 0;
 *                 sum2 = 0;
 *                 sum3 += arr[i][i];   // 이렇게 해도 무방
 *                 sum4 += arr[i][99-i];    // 이렇게 해도 무방
 *
 *                 for(int j=0; j<100; j++){
 *                     sum1 += arr[i][j];
 *                     sum2 += arr[j][i];
 *                 }
 *                 max = Math.max(max,sum1);
 *                 max = Math.max(max,sum2);
 *             }
 */