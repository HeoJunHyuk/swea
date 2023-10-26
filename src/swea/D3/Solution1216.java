package swea.D3;

import java.io.IOException;
import java.util.Scanner;

// [S/W 문제해결 기본] 3일차 - 회문2
// 풀이: 회문1에서 연장된 문제. 같은 로직에 길이를 구하는 for 문을 하나 더 추가 -> 4중 for
public class Solution1216 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int T = sc.nextInt();   // 테스트 케이스 번호
            char[][] board = new char[100][100];
            int max = 0;

            for (int i = 0; i < 100; i++) { // 데이터 입력
                board[i] = sc.next().toCharArray();
            }

            for (int k = 0; k <= 100; k++) {    // 회문 길이를 구하는 for문

                for (int i = 0; i < 100; i++) { // 행 확인
                    for (int j = 0; j < 100 - k + 1; j++) {

                        boolean check = true;
                        for (int l = 0; l < k / 2; l++) {
                            if (board[i][j + l] != board[i][j + k - 1 - l]) {
                                check = false;
                                break;
                            }
                        }
                        if (check) max = Math.max(max, k);
                    }
                }

                for (int i = 0; i < 100; i++) { // 열 확인
                    for (int j = 0; j < 100 - k + 1; j++) {

                        boolean check = true;
                        for (int l = 0; l < k / 2; l++) {
                            if (board[j + l][i] != board[j + k - 1 - l][i]) {
                                check = false;
                                break;
                            }
                        }
                        if (check) max = Math.max(max, k);
                    }

                }
            }

            System.out.println("#" + T + " " + max);

        }
    }

}
