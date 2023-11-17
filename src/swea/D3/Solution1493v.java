package swea.D3;

import java.util.Scanner;

// 수의 새로운 연산 ***
// 풀이: 배열 X, 규칙을 찾아야 함. for문을 잘 사용해야 함.
//      for (int i = 1;; i++) {
//          for (int x = 1, y = i; x <= i; x++, y--)

public class Solution1493v {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {

            int p = sc.nextInt();
            int q = sc.nextInt();

            int[] coordiP = getCoordi(p);
            int[] coordiQ = getCoordi(q);

            // 좌표 연산
            int[] newCoordi = {coordiP[0] + coordiQ[0], coordiP[1] + coordiQ[1]};

            // 좌표를 통해 값 구하기
            int result = getValue(newCoordi);

            System.out.println("#" + tc + " " + result);
        }
    }

    // 값을 받아서, 좌표 구하기
    private static int[] getCoordi(int value) {
        int count = 1;
        for (int i = 1;; i++) { // i는 1씩 계속 증가
            for (int x = 1, y = i; x <= i; x++, y--) {  // (1,1) -> (1,2) -> (2,1) -> (1,3) ->... 좌표마다 count로 ++하면서 값을 넣는 식
                if (count == value) {
                    return new int[]{x, y}; // 좌표 구해서 배열에 넣기
                }
                count++;
            }
        }
    }

    // 좌표를 받아서, 값 구하기
    private static int getValue(int[] coordi) {
        int count = 1;
        for (int i = 1;; i++) {
            for (int x = 1, y = i; x <= i; x++, y--) {
                if (x == coordi[0] && y == coordi[1]) {
                    return count;
                }
                count++;
            }
        }
    }
}

/**
 * public static void main(String[] args) {
 * 		Scanner scan = new Scanner(System.in);
 *
 * 		int T = scan.nextInt();
 *
 * 		for(int tc=1; tc<=T; tc++) {
 * 			int p = scan.nextInt();
 * 			int q = scan.nextInt();
 * 			int result = 0;
 *
 *
 * int sum1 = 0;
 *     int x1 = 0;
 *     int y1 = 0;
 *
 *          p 에 대한 x, y 좌표 구하기
 * 			for(int i=1; ; i++) {
 *                     sum1 += i;
 *                     if(sum1 >= p) {  어느 대각선에 존재하는지 확인
 *                     x1 = i - (sum1-p);   예를 들어 4번째 대각선에 존재한다면( i = 4 )
 *                     y1 = (i+1) - x1;     4번째 라인에 있는 수들은 다 x+y가 5이다. -> x + y = i + 1
 *                     break;
 *                     }
 *                     }
 *
 *
 *          q 에 대한 x, y 좌표 구하기
 *                     int sum2 = 0;
 *                     int x2 = 0;
 *                     int y2 = 0;
 *                     for(int i=1; ; i++) {
 *                     sum2 += i;
 *                     if(sum2 >= q) {
 *                     x2 = i - (sum2-q);
 *                     y2 = (i+1) - x2;
 *                     break;
 *                     }
 *                     }
 *
 *          최종 결과 값 구하기
 *                     int x3 = x1 + x2;
 *                     int y3 = y1 + y2;
 *                     int sum3 = 1;
 *                     for(int i=1; i<(x3+y3)-1; i++) {     왼쪽 열을 보면 1 + 1 + 2 + 3 + 4 +... 그래서 구하고자 하는 좌표가 있는 대각선의 좌측 꼭대기를 구함.
 *         sum3 += i;                                       좌측 꼭대기 값을 구했음.
 *         }
 *         result = sum3 + (x3-1);                          좌측 꼭대기 값에서 x좌표에서 1만큼 뺀 값을 더해주면 그 값이 정답임
 *
 *         System.out.println("#" + tc + " " + result);
 *         //System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
 *
 *         }
 *
 *
 *
 *         scan.close();
 *         }
 */