package swea.D3;

import java.io.IOException;
import java.util.Scanner;

// [S/W 문제해결 기본] 3일차 - 회문1
// 풀이: 3중 for문, if문을 활용 행,열 검사 -> for문의 범위를 잘 설정해야 함
public class Solution1215 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int N = sc.nextInt();   // 찾아야 하는 회문 길이
            char[][] board = new char[8][8];
            int cnt = 0;

            for (int i = 0; i < 8; i++) {
                board[i] = sc.next().toCharArray();
            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8 - N + 1; j++) {
                    boolean[] palindrome = {true, true};

                    for (int k = 0; k < N / 2; k++) {   // 가로
                        if (board[i][j + k] != board[i][j - k + N - 1]) {
                            palindrome[0] = false;
                        }
                    }
                    for (int k = 0; k < N / 2; k++) {   // 세로
                        if (board[j + k][i] != board[j - k + N - 1][i]) {
                            palindrome[1] = false;
                        }
                    }
                    if (palindrome[0]) cnt++;
                    if (palindrome[1]) cnt++;

                }
            }
            System.out.println("#" + tc + " " + cnt);

        }
    }

}
