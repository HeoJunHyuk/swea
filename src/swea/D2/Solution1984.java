package swea.D2;

import java.io.IOException;
import java.util.Scanner;

// 중간 평균값 구하기 
// 풀이: Math.max, Math.min 값 구해서 총 sum에서 빼주기, 평균 구하기 -> Math.round(avg)를 int 형태로 변경
public class Solution1984 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int max = Integer.MIN_VALUE; // 초기화를 아주 작은 값으로 설정
            int min = Integer.MAX_VALUE; // 초기화를 아주 큰 값으로 설정
            int sum = 0;
            double avg = 0;
            int[] arr = new int[10];

            for (int i = 0; i < 10; i++) {
                arr[i] = sc.nextInt();
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i]);
                sum += arr[i];
            }
            sum -= max;
            sum -= min;
            avg = (double) sum / 8.0;   // 8로 나누면 소수점 버림
            // 평균을 계산할 때 정수로 나누는 대신 (double)을 사용하여 나눗셈을 실수로 수행
            int result = (int) Math.round(avg); // 평균을 반올림한 결과를 정수로 변환
            System.out.printf("#%d %d\n", tc, result);  // Math.round() = double 형태, 그래서 int로 형 변환
        }
    }
}
