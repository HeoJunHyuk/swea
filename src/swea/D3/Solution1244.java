package swea.D3;

import java.util.Scanner;

// [S/W 문제해결 응용] 2일차 - 최대 상금 ******** -> DFS 문제
// 풀이: 완전 탐색 -> DFS 재귀 호출 ( greedy X ) + 시간 초과를 해결하기 위해, chance가 문자열보다 클 때, chance = arr.length
// int -> int[] :  arr = Integer.toString(num).chars().map(c -> c - '0').toArray();

public class Solution1244 {
    static String[] arr;
    static int max, chance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1 ; tc <= T ; tc++) {
            arr = sc.next().split("");  // 문자열 배열에 각각 숫자 한개씩 들어감
            chance = sc.nextInt();

            max = 0;
            // 시간초과 최적화
            if(arr.length < chance) {	// swap 횟수가 자릿수보다 클 때
                chance = arr.length;	// 자릿수만큼만 옮겨도 전부 옮길 수 있음
            }
            dfs(0, 0);
            System.out.println("#" + tc + " " + max);
        }
    }
    static void dfs(int start, int cnt) {
        if(cnt == chance) {
            String result = "";
            for(String s : arr)
                result += s;
            max = Math.max(max, Integer.parseInt(result));
            return;
        }
        for(int i = start; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                // swap
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                dfs(i, cnt + 1);	// 깊이 +1
                // 다시 swap 해서 되돌림
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}