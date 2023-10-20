package swea.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;

// Base64 Decoder ****(문제 이해가 어려움, 라이브러리 미사용시 어려움)
// 풀이: 자바의 Base64 라이브러리를 사용해서 getDecoder().decode() 사용
public class Solution1928 {
// 1 byte = 8 bit, MSB(Most Significant Bit)는 제일 자릿수가 큰 왼쪽 비트
// ASCII 코드에서 숫자와 영문자는 모두 1byte가 1글자 이므로, 버퍼안에 세글자를 집어넣으라는 간단한 뜻
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            String str = br.readLine();
            String result = new String(Base64.getDecoder().decode(str));
            System.out.println("#" + tc + " " + result);
        }
    }
}

/**
 * 1. 표1을 보고 입력받은 문자들을 각각 대응하는 숫자로 변경한다.
 * 2. 각 숫자들을 6자리 이진수로 표현하고, 이 이진수들을 한 줄로 쭉 이어 붙인다.
 * 3. 한 줄로 쭉 이어붙인 이진수들을 8자리씩 끊어서 십진수로 바꾼다.
 * 4. 각각의 십진수를 아스키 코드로 변환한다.
 */
