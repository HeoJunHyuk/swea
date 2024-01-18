package backjoon.Mathematics;   // 패키지 없애야 함

import java.util.Scanner;
/**
 입력
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 StringTokenizer st = new StringTokenizer(br.readLine()); -> st.nextToken()

 출력
 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 bw.write(String.valueOf(숫자)); 출력
 bw.newLine(); 줄바꿈

 StringBuilder sb = new StringBuilder();
 -> sb.append().append('\n') 로 모아주고, sout(sb)
*/

// 평균 [bronze 1]
// 풀이 : 단순 연산, 소수점을 반환해야 해서 float형을 사용해야 함.
public class Main1546 {  // Main 으로 해야함, public class 는 Main 하나여야만 함.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        float[] arr = new float[N];
        float avg = 0;
        float max = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] > max) max = arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            avg += (arr[i]/ max * 100) / N;
        }

        System.out.println(avg);

    }
}
