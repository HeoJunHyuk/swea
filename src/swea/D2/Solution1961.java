package swea.D2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// 숫자 배열 회전
// 풀이: board[][]을 회전각에 따라 인덱스 읽는 순서를 바꿔서 출력함
public class Solution1961 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[][] board = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            System.out.println("#" + tc);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(board[N-j-1][i]);  //90 회전 행
                }
                System.out.print(" ");
                for (int j = 0; j < N; j++) {
                    System.out.print(board[N-i-1][N-j-1]);  //180 회전 행
                }
                System.out.print(" ");
                for (int j = 0; j < N; j++) {
                    System.out.print(board[j][N-i-1]);  //270 회전 행
                }
                System.out.println();
            }
        }
    }
}
