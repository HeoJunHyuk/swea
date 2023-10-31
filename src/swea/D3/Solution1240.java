package swea.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// [S/W 문제해결 응용] 1일차 - 단순 2진 암호코드
// 풀이: 문제 이해를 잘 해야 함. 주어진 숫자(암호코드)에 해당하는 이진수 또는 십진수를 static 배열로 만들어두고, 이의 인덱스 값을 이용해야 함.
// i가 0번째부터 시작이라면 -> String.substring(i, i + 57), i가 1번째부터 시작이라면 -> (i, i + 7)

public class Solution1240 {
    static int[] pw;	// 배열에서 해독한 암호 코드
    static int[] code = {13, 25, 19, 61, 35, 49, 47, 59, 55, 11}; // 주어진 숫자의 해당하는 이진수를 십진수로 변환

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        br.readLine();
        for (int test_case = 1; test_case <= 10; test_case++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            pw = new int[8];
            String line;

            for (int i = 0; i < N; i++) {
                line = br.readLine();
                for (int j = M - 1; j >= M - 56 - 1; j--) {	// 배열 뒤에서부터 탐색, 암호코드 길이보다 인덱스가 작아지면 탐색 중지
                    if (line.charAt(j) == '1') {	// 1이면 암호코드 맨 뒤 숫자
                        int index = 0;
                        for (int k = j - 55; k <= j; k += 7) {
                            pw[index++] = convertCode(line.substring(k, k + 7));	// 이진 암호코드를 숫자로 변환
                        }
                        break;
                    }
                }
            }
            bw.write(String.format("#%d %d\n",test_case, validateCode()));	// 변환된 숫자로 암호코드 검증
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int validateCode() {
        int validate = 0;
        int sum = 0;
        for(int i = 0; i<8; i++) {
            if(i % 2 == 0) {
                validate += 3*pw[i];	// 홀수번째면 3 곱해서 저장
            } else {
                validate += pw[i];
            }
            sum += pw[i];
        }

        if(validate % 10 == 0) {	// 검증코드가 10의 배수이면 정상 암호코드
            return sum;
        } else {
            return 0;
        }
    }

    private static int convertCode(String binary) {
        int sum = 0;
        int n = 1;
        for(int i = 0; i<7; i++) {	// 이진수를 십진수로 변환
            if(binary.charAt(6-i) == '1') {
                sum += n;
            }
            n *= 2;
        }
        for(int i = 0; i<10; i++) {	// 주어진 암호코드 배열에서 비교하여 같을때 해당 인덱스 추출
            if(sum == code[i]) {
                return i;
            }
        }
        return 0;
    }
}
/**
 * class Solution {
 * 	public static String[] code = { "0001101", "0011001", "0010011", "0111101",
 * 			"0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};
 *
 * 	public static int[] toNum(String s) {   num[8] 배열에다가 7개씩 나눈 암호코드의 각각의 인덱스를 저장함.
 * 		int num[] = new int[8];
 * 		int idx = 0;
 * 		for (int i = 0; i < s.length(); i += 7) {
 * 			String tmp = s.substring(i, i + 7);
 * 			for (int j = 0; j < code.length; j++) {
 * 				if (tmp.equals(code[j])) {
 * 					num[idx++] = j;
 * 					break;
 *              }
 * 		    }
 * 		return num;
 * 	    }
 *  }
 *
 * 	public static int isValid(String code) {    num[] 배열을 이용해서 정상 암호 코드인지 확인하고 맞으면 그 값을 반환
 * 		int num[] = toNum(code);
 * 		int sum = 0;
 * 		int total = 0;
 *
 * 		for (int i = 0; i < num.length; i++) {
 * 			sum += num[i];
 * 			if (i % 2 == 0) total += 3 * num[i];
 * 			else total += [i];
 * 		}
 *
 * 		if (total % 10 == 0)
 * 			return sum;
 * 		return 0;
 * 	}
 *
 * 	public static void main(String args[]) throws Exception {
 * 		Scanner sc = new Scanner(System.in);
 * 		int T = sc.nextInt();
 * 		for (int test_case = 1; test_case <= T; test_case++) {
 * 			int n = sc.nextInt();
 * 			int m = sc.nextInt();
 *
 * 			String code = "";
 * 			for (int i = 0; i < n; i++) {
 * 				String s = sc.next();
 * 				if (code.isEmpty()) {
 * 					for (int j = m - 1; j >= 0; j--) {
 * 						if (s.charAt(j) == '1') {
 * 							code = s.substring(j - 55, j + 1);  1번째부터 56번째까지의 암호코드들이 code에 담김
 * 							break;
 *                                                }*                }
 *            }
 * 			}
 * 			System.out.println("#" + test_case + " " + isValid(code));
 *    }
 * 	}
 * }
 */