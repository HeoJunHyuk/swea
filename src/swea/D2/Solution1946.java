package swea.D2;

import java.util.Scanner;

// 간단한 압축 풀기 ***
// 풀이: 입력 받은 알파벳을 char[]에 담고, 이를 해당 숫자만큼 출력 -> cnt++ , cnt = 10이 되면, 줄 바꿈 추가
public class Solution1946 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            char[] alpha = new char[N];
            int[] k = new int[N];

            for (int i = 0; i < N; i++) {
                alpha[i] = sc.next().charAt(0);
                k[i] = sc.nextInt();
            }

            int cnt = 0;
            System.out.println("#" + tc);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < k[i]; j++) {
                    System.out.printf(String.valueOf(alpha[i]));
                    cnt++;
                    if (cnt == 10) {
                        System.out.println();
                        cnt = 0;
                    }
                }
            }
            System.out.println();
        }

    }
}
