package swea.D2;

import java.io.IOException;
import java.util.Scanner;

// 스도쿠 검증   *****
// 풀이: 행,열,격자 검사 따로 실행, new arr[9] 만들어서 1~9까지 안들어간 숫자가 있는지 확인 -> arr[(map[i][j] - 1)]++;
public class Solution1974 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int[][] map = new int[9][9];
            boolean sign = true;

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            //행 체크
            for (int i = 0; i < 9; i++) {
                int[] arr = new int[9];
                for (int j = 0; j < 9; j++) {
                    arr[(map[i][j] - 1)]++; // arr[]에 일렬로 줄세우기 없는 숫자 부분은 0이 될거고, 중복되는 숫자는 2가 됨.
                    }
                for (int a = 0; a < 9; a++) {
                    if (arr[a] == 0) {  // 0이 있으면 어느 숫자가 arr[]에 없는 것이기 때문에 스도쿠 X
                        sign = false;
                        break;
                    }
                }
            }
            //열 체크
            for (int j = 0; j < 9; j++) {   // 행 체크 로직에서 i와 j의 위치만 바꿈
                int[] arr = new int[9];
                for (int i = 0; i < 9; i++) {
                    arr[(map[i][j] - 1)]++;
                }
                for (int a = 0; a < 9; a++) {
                    if (arr[a] == 0) {
                        sign = false;
                        break;
                    }
                }
            }

            //3X3 격자 확인 -> 4중 for문을 사용
            for (int i = 0; i <= 6; i += 3) {
                for (int j = 0; j <= 6; j += 3) {
                    int[] arr = new int[9];

                    for (int x = i; x < i + 3; x++) {
                        for (int y = j; y < j + 3; y++) {
                            arr[(map[x][y] - 1)]++; // 1~9 숫자 검증은 위와 동일
                        }
                    }

                    for (int z = 0; z < 9; z++) {
                        if (arr[z] == 0) {
                            sign = false;
                            break;
                        }
                    }

                }
            }

            if (sign == true) {
                System.out.println("#" + tc + " " + 1);
            }else System.out.println("#" + tc + " " + 0);
        }
    }
}
