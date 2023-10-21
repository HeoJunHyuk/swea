package swea.D2;

import java.util.Arrays;
import java.util.Scanner;

// [S/W 문제해결 기본] 최빈수 구하기
// 풀이: 1000개의 점수를 scores[]에 입력 받고 이를 정렬해준 후, 내림차순으로 다시 정렬.
// if문 활용하여 똑같은 점수가 나오면 cnt++, 이를 max와 비교, 해당 max를 만든 때의 scores[i]가 result
public class Solution1204 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[] scores = new int[1000];
            int result = 0;
            int temp = 0;
            int cnt = 0;
            int max = 0;

            for (int i = 0; i < scores.length; i++) {
                scores[i] = sc.nextInt();
            }
            Arrays.sort(scores);    // 오름차순

            for (int i = 0; i < scores.length / 2; i++) {   // 내림차순
                int a = scores[i];
                scores[i] = scores[scores.length - 1 - i];
                scores[scores.length - 1 - i] = a;
            }

            for (int i = 0; i < scores.length; i++) {
                if (temp == scores[i]) {
                    cnt++;
                    if (cnt > max) {
                        max = cnt;
                        result = scores[i];
                    }
                } else cnt = 0;
                temp = scores[i];
            }

            System.out.println("#" + tc + " " + result);
        }
    }
}

/**
 * import java.util.Scanner;
 *
 * public class Solution1204 {
 *
 *     public static void main(String[] args) {
 *         Scanner sc = new Scanner(System.in);
 *         int T = sc.nextInt();
 *
 *         for (int tc = 1; tc <= T; tc++) {
 *             int N = sc.nextInt();
 *             int[] scores = new int[101]; // 0부터 100까지의 점수를 저장하기 위한 배열
 *             int maxFrequency = 0;
 *             int mode = 0;
 *
 *             // 점수를 입력받고 해당 점수의 빈도를 세기
 *             for (int i = 0; i < 1000; i++) {
 *                 int score = sc.nextInt();
 *                 scores[score]++;
 *             }
 *
 *             // 최빈수 찾기
 *             for (int i = 0; i <= 100; i++) {
 *                 if (scores[i] >= maxFrequency) {
 *                     maxFrequency = scores[i];
 *                     mode = i;
 *                 }
 *             }
 *
 *             System.out.println("#" + tc + " " + mode);
 *         }
 *     }
 * }
 */