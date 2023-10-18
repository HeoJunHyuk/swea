package swea.D2;

import java.io.IOException;
import java.util.Scanner;

// 쉬운 거스름돈
// 풀이: /, % 을 이용한 문제
public class Solution1970 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();   //32850 89410
            int[] money = new int[8];

            money[0] = N / 50000;
            N %= 50000;
            money[1] = N / 10000;
            N %= 10000;
            money[2] = N / 5000;
            N %= 5000;
            money[3] = N / 1000;
            N %= 1000;
            money[4] = N / 500;
            N %= 500;
            money[5] = N / 100;
            N %= 100;
            money[6] = N / 50;
            N %= 50;
            money[7] = N / 10;

            System.out.println("#" + tc);
            for (int i = 0; i < 8; i++) {
                System.out.print(money[i] + " ");
            }
            System.out.println();
        }
    }
}
/**
 * for (int tc=1; tc<=t; tc++) {
 * 			int num = sc.nextInt();
 * 			int[] moneys = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
 * 			int[] result = new int[8];
 *
 * 			for (int i=0; i<8; i++) {
 * 				result[i] = num / moneys[i];
 * 				num %= moneys[i];
 *                        }
 *
 * 			System.out.println("#" + tc);
 * 			for (int i=0; i<8; i++) {
 * 				System.out.print(result[i] + " ");
 *            }
 * 			System.out.println();* 		}
 */