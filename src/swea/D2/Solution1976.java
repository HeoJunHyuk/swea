package swea.D2;

import java.io.IOException;
import java.util.Scanner;

// 시각 덧셈
// 풀이: 단순 덧셈, 뺄셈
public class Solution1976 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int hourA = sc.nextInt();
            int minA = sc.nextInt();
            int hourB = sc.nextInt();
            int minB = sc.nextInt();
            int result_hour = 0;
            int result_min = 0;

            result_hour = hourA + hourB;

            result_min = minA + minB;
            if (result_min > 59) {
                result_min -= 60;   // %60 를 써서 나머지로 할수도 있음.
                result_hour += 1;   // /60 를 써서 몫으로 할수도 있음.
            }
            if (result_hour > 12) {
                result_hour -= 12;  // %12 로 해서 나머지로 할 수 있음.
            }
            System.out.println("#" + tc + " " + result_hour + " " + result_min);
        }
    }
}
