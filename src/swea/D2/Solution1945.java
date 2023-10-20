package swea.D2;

import java.util.Scanner;

// 간단한 소인수분해
// 풀이: 소인수 2, 3, 5, 7, 11 을 각각 % == 0 이면 result[i]++
public class Solution1945 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[] result = new int[5];
            int[] arr = {2, 3, 5, 7, 11};

            for (int i = 0; i < 5; i++) {
                while (true) {
                    if (N % arr[i] == 0) {
                        result[i]++;
                        N /= arr[i];
                    } else {
                        break;
                    }
                }
            }
            System.out.print("#" + tc + " ");
            for (int i = 0; i < 5; i++) {
                System.out.print(result[i] + " ");

            }
            System.out.println();
        }

    }
}

/**
 * for(int test_case = 1; test_case <= T; test_case++)
 *         {
 *             int n=sc.nextInt();
 *             int a = 0;
 *             int b = 0;
 *             int c = 0;
 *             int d = 0;
 *             int e = 0;
 *             while(true){
 *                 if(n % 2 == 0){
 *                     n /= 2;
 *                     a++;
 *                 }else if(n % 3 == 0){
 *                     n /= 3;
 *                     b++;
 *                 }else if(n % 5 == 0){
 *                     n /= 5;
 *                     c++;
 *                 }else if(n % 7 == 0){
 *                     n /= 7;
 *                     d++;
 *                 }else if(n % 11 == 0){
 *                     n /= 11;
 *                     e++;
 *                 }
 *                 if(n == 1)
 *                     break;
 *             }
 *             System.out.println("#"+test_case+" "+a+" "+b+" "+c+" "+d+" "+e);
 *         }
 */