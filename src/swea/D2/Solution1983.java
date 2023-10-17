package swea.D2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 조교의 성적 매기기
// 풀이:
public class Solution1983 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            String[] grade = new String[]{"D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"};
            double[] scores = new double[N];

            for (int i = 0; i < N; i++) {
                int mid_score = sc.nextInt();
                int final_score = sc.nextInt();
                int sub_score = sc.nextInt();
                scores[i] = mid_score * 0.35 + final_score * 0.45 + sub_score * 0.2;
            }

            String result = "";
            double goal = scores[K - 1];
            Arrays.sort(scores);
            for (int i = 0; i < N; i++) {
                if (goal == scores[i]) {
                    result = grade[i / (N / 10)];
                    break;
                }
            }
            System.out.println("#" + tc + " " + result);

        }
    }
}

/**
 * String[] scores = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
 *
 * 		for (int tc=1; tc<=t; tc++) {
 * 			int n = sc.nextInt(); // 학생 수
 * 			int k = sc.nextInt(); // 학점을 알고싶은 학생의 번호
 *
 * 			ArrayList<Double> arr = new ArrayList<>();
 * 			for (int i=0; i<n; i++) {
 * 				int a = sc.nextInt();
 * 				int b = sc.nextInt();
 * 				int c = sc.nextInt();
 * 				double sum_value = (a * 0.35) + (b * 0.45) + (c * 0.2);
 * 				arr.add(sum_value);
 *                        }
 *
 * 			double k_score = arr.get(k-1);
 * 			Collections.sort(arr, Collections.reverseOrder());
 *
 * 			int value = (int)(n/10);
 * 			int result = (int)(arr.indexOf(k_score) / value);
 *
 * 			System.out.println("#" + tc + " " + scores[result]);* 		}
 * 	}
 */