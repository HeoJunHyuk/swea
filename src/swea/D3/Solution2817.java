package swea.D3;

import java.util.Scanner;

// 부분 수열의 합
// 풀이: 재귀 함수 활용, 가능한 모든 부분 수열의 합을 확인 -> 햄버거 문제랑 같음. 선택한 경우와 선택하지 않는 경우로 나눔
public class Solution2817 {

    static int N, K, result;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            K = sc.nextInt();
            arr = new int[N];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            result = 0; // tc 마다 결과 초기화
            search(0, 0);
            System.out.println("#" + tc + " " + result);
        }
    }

    private static void search(int cnt, int sum) {
        if (cnt == N) {
            if (sum == K) {
                result++;
            }
            return;
        }
        // 현재 위치의 숫자를 선택한 경우
        search(cnt + 1, sum + arr[cnt]);
        // 현재 위치의 숫자를 선택하지 않은 경우
        search(cnt + 1, sum);
    }
}
