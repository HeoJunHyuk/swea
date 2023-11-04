package swea.D3;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// [S/W 문제해결 기본] 5일차 - GNS
// 풀이: 문자열을 받고, rule[]과 비교해서 해당하는 문자열에 숫자를 배치하고, 이를 sort한 뒤 for문에서 rule[arr[i]] 을 출력함
// 다른 풀이 : 이중 for문에서 입력받은 문자열들을 처음부터 끝까지 돌리면서 rule[0]부터 rule[9]까지 동일한 것이 있으면 출력하게끔 함.
/**
 * for(int i = 0; i < 10; i++) {
 *  *     for(int j = 0; j < no; j++) {
 *  *         if(arr[j].equals(num[i]))
 */
public class Solution1221 {

    static String[] rule = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            String test_case = sc.next();
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                String str = sc.next();
                if (str.equals(rule[0])) {
                    arr[i] = 0;
                } else if (str.equals(rule[1])) {
                    arr[i] = 1;
                } else if (str.equals(rule[2])) {
                    arr[i] = 2;
                } else if (str.equals(rule[3])) {
                    arr[i] = 3;
                } else if (str.equals(rule[4])) {
                    arr[i] = 4;
                } else if (str.equals(rule[5])) {
                    arr[i] = 5;
                } else if (str.equals(rule[6])) {
                    arr[i] = 6;
                } else if (str.equals(rule[7])) {
                    arr[i] = 7;
                } else if (str.equals(rule[8])) {
                    arr[i] = 8;
                } else if (str.equals(rule[9])) {
                    arr[i] = 9;
                }
            }
            Arrays.sort(arr);

            System.out.println(test_case);

            for (int i = 0; i < arr.length; i++) {
                System.out.print(rule[arr[i]] + " ");
            }
        }
    }

}

/**
 * String a = sc.nextLine();
 * String[] b = a.split("");
 * int no = Integer.parseInt(b[1]);
 *
 * String value = sc.nextLine();
 * String[] arr = value.split("");
 * souf("#%d", tc);
 * sout
 *
 * for(int i = 0; i < 10; i++) {
 *     for(int j = 0; j < no; j++) {
 *         if(arr[j].equals(num[i])) {      // num[] 배열은 나와 같이 static 으로 설정해놓음.
 *             System.out.print(arr[j] + " ");
 *         }
 *     }
 * }
 */