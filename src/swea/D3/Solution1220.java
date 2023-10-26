package swea.D3;

import java.io.IOException;
import java.util.Scanner;

// [S/W 문제해결 기본] 5일차 - Magnetic
// 풀이: 문제 이해 후 (1,2) 순서인 것만 카운팅해주면 되는 규칙을 잘 찾아야함. for문과 if문, boolean check 를 사용해서 풀이
public class Solution1220 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int N = sc.nextInt();   // 100
            int[][] map = new int[N][N]; // 100 X 100 배열
            int result = 0;

            // 입력 받기 -> 1: 빨(N) 2: 파(S)
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < map.length; i++) {
                boolean check = false;

                for (int j = 0; j < map.length; j++) {
                    if (map[j][i] == 1) {
                        check = true;
                    } else if (map[j][i] == 2) {
                        if (check) {
                            result++;
                            check = false;
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }

}
