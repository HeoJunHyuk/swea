package swea.D2;

import java.util.Scanner;

// 날짜 계산기
// 풀이: 월에 따른 날짜를 다 더해서 총 합끼리 비교. result = sumB - sumA + 1
public class Solution1948 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수
        for (int tc = 1; tc <= T; tc++) {
            int monA = sc.nextInt();
            int dayA = sc.nextInt();
            int monB = sc.nextInt();
            int dayB = sc.nextInt();
            int sumA = 0;
            int sumB = 0;
            int result = 0;
            int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            if (monA != 1) {    // if문 쓰지 않아도 됨. monA가 1일때는 아래 for문 조건에 맞지 않아서 for문 실행 안됨.
                for (int i = 0; i < monA - 1; i++) {
                    sumA += days[i];
                }
                sumA += dayA;
                for (int i = 0; i < monB - 1; i++) {
                    sumB += days[i];
                }
                sumB += dayB;
            } else {
                sumA = dayA;
                if (monB == 1) {
                    sumB = dayB;
                } else {
                    for (int i = 0; i < monB - 1; i++) {
                        sumB += days[i];
                    }
                    sumB += dayB;
                }
            }
            result = sumB - sumA + 1;
            System.out.println("#" + tc + " " + result);
        }

    }
}
