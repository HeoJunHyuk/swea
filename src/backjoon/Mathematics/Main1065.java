package backjoon.Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 한수
// 풀이 : 1~99 는 무조건 한수, 100 ~ 1000 에서 해당 숫자의 각 자릿 수를 비교하여 한수인지 확인
public class Main1065 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(logic(Integer.parseInt(br.readLine())));
    }

    public static int logic(int num) {
        int cnt = 0;

        if (num < 100) {
            return num;
        } else {
            cnt = 99;
            for (int i = 100; i <= num; i++) {
                int hun = i / 100;
                int ten = (i / 10) % 10;
                int one = i % 10;

                if ((hun - ten) == (ten - one)) {
                    cnt++;
                }
            }

        }
        return cnt;
    }
}

/**
 * public class Hansu_1065 {
 *
 * 	public static void main(String[] args) {
 * 		Scanner sc = new Scanner(System.in);
 * 		int num = sc.nextInt(); //숫자 N입력
 * 		int count = 0; //한수 개수 카운팅
 * 		for (int i = 1; i <= num; i++) { //입력 범위가 1이상이므로 1부터 시작.
 * 			if (i <= 99) { //1~99까지는 모두 한수이므로 무조건 +1
 * 				count += 1;
 *                        } else if (i <= 999) { //100부터는 조건을 확인해서 한수 조건을 충족하면 +1
 * 				String[] num_str = Integer.toString(i).split(""); //각 자리수를 자정할 문자열 배열 생성.
 * 				if ((Integer.parseInt(num_str[1]) - Integer.parseInt(num_str[0])) == (Integer.parseInt(num_str[2])- Integer.parseInt(num_str[1]))) { //백의자리 십의자리 일의자리를 각각 a, b, c라고 생각하고 b-a == c-b 이면 한수이므로 +1
 * 					count += 1;
 *                }
 *            }* 		}
 * 		System.out.println(count);
 * 	}
 * }
 */
