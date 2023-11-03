package swea.D3;

import java.util.Scanner;

// 정곤이의 단조 증가하는 수
// 풀이: 이중 for문 j= i + 1로 해서 arr[i] * arr[j] 를 isIncreasing(단조 증가인지 확인) 함수 호출에 사용해서 단조 증가하는 수면 max 갱신
// 내 코드는 자꾸 테케가 하나만 맞음. 아래 코드가 정답 처리됨. ( 사실 똑같이 했는데 왜 틀린지 모르겠음.. )
public class Solution6190 {

    static int N, max;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        for (int tc = 1; tc <= 10; tc++) {
            N = sc.nextInt();   // 정수 갯수
            arr = new int[N];

            for (int i = 0; i < N; i++) {   // 정수들 입력
                arr[i] = sc.nextInt();
            }
            max = -1;
            calculate();
            System.out.println("#" + tc + " " + max);
        }
    }

    private static void calculate() {
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int temp = arr[i] * arr[j];

                if (isIncreasing(temp)) {
                    max = Math.max(max, temp);
                }
            }
        }
    }

    private static boolean isIncreasing(int num) {
        String numStr = Integer.toString(num);
        for (int i = 0; i < numStr.length() - 1; i++) {
            if (numStr.charAt(i) - '0' > numStr.charAt(i + 1) - '0') {
                return false;
            }
        }
        return true;
    }

}
/**
 * public class Solution {
 *
 *     static int N;
 *     static int max;
 *     static int[] arr;
 *     static StringBuffer sb = new StringBuffer();
 *
 *     public static void main(String[] args) throws Exception {
 *
 *         Scanner sc = new Scanner(System.in);
 *         int T = sc.nextInt();
 *
 *         for (int tc = 1; tc <= T; tc++) {
 *
 *             max = -1; //-1 초기화
 *             N = sc.nextInt();
 *             arr = new int[N];
 *
 *             for (int i = 0; i < N; i++) {
 *                 arr[i] = sc.nextInt();
 *             }
 *             for (int i = 0; i < N; i++) {
 *                 for (int j = i + 1; j < N; j++) {
 *                     int multi = arr[i] * arr[j];
 *                     increase(multi); //곱이 단조 증가가 맞는지 확인하여 max값 업데이트 할 함수
 *                 }
 *
 *             }
 *             sb.append("#" + tc).append(" ").append(max).append("\n");
 *         }
 *         System.out.println(sb);
 *     }
 *
 *     public static void increase(int num) {
 *         boolean up = true;
 *         String s = Integer.toString(num);
 *
 *         for (int i = 0; i < s.length() - 1; i++) {
 *             if (s.charAt(i) - '0' > (s.charAt(i + 1) - '0')) { //앞의 수가 더 크면 단조증가수 아님
 *                up = false;
 *                 break;
 *             }
 *         }
 *         if (up) { //max update
 *             max = Math.max(num,max);
 *         }
 *     }
 * }
 */