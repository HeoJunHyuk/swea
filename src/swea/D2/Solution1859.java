package swea.D2;

import java.util.Scanner;

// 백만 장자 프로젝트
// 풀이 : 뒤에서 부터 돌면서 풀기 -> 가장 큰 이익을 얻기 위해선 가장 높은 매매가일 때 판매해야 하기 때문
public class Solution1859 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n=sc.nextInt();
            long diff=0;    // max - current = diff
            // int로 하면 데이터 범위가 초과되어서 long
            int max_value=0;
            int[] arr=new int[n];
            for (int j = 0; j < n; j++) {
                arr[j]=sc.nextInt();
            }
            for (int j = n-1; j >=0; j--) {
                if(arr[j]>max_value) {
                    max_value=arr[j];   // 현재 값이 max보다 크면 max 갱신
                }
                diff += max_value - arr[j]; // 작으면 그 차이가 이익이므로 더함
            }
            System.out.printf("#%d %d\n", i+1, diff);
        }
        sc.close();
    }
}
