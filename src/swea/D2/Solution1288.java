package swea.D2;

import java.util.Scanner;

// 새로운 불면증 치료법
// 풀이:
public class Solution1288 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            boolean arr[]=new boolean[10];
            String A=sc.next();
            int num=Integer.parseInt(A);
            int count=0;
            int cnt=1;
            while(true){
                for(int i=0;i<A.length();i++){
                    int temp=Integer.parseInt(A.substring(i,i+1));
                    if(arr[temp]==false){
                        arr[temp]=true;
                        count++;
                    }
                }
                if(count==10)
                    break;
                else{
                    cnt++;
                    A=Integer.toString(num*cnt);
                }
            }
            System.out.println("#"+test_case+" "+A);
        }
    }
    /** 내 풀이
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[] arr = new int[10]; // 0에서 9까지의 숫자를 저장하는 배열
            int cnt = 0;
            int result = 0;
            while (true) {

                // N을 다음 배수로 증가시킴
                result += N;
                int temp = result;

                // result의 각 자리수에 있는 숫자를 arr 배열에 표시
                while (temp > 0) {
                    int digit = temp % 10;
                    arr[digit] = 1;
                    temp /= 10;
                }

                // arr 배열에 0에서 9까지 모든 숫자가 나왔는지 확인
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] > 0) {
                        cnt++;
                    }
                }
                if (cnt == 10) {
                    break;
                }
            }
            System.out.println("#" + tc + " " + result);
        }
    }*/

}


/**
 * Scanner sc = new Scanner(System.in);
 * 		int t = sc.nextInt();
 * 		for (int tc = 1; tc <= t; tc++) {
 * 			int cnt = 0;
 * 			int ans = 0;
 * 			boolean[] visited = new boolean[10];
 * 			int n = sc.nextInt();
 * 			int num = 0;
 *
 * 			while(cnt < 10) {
 * 				ans += 1;
 * 				num += n;
 * 				String string_num = Integer.toString(num);
 * 				for (int i = 0; i < string_num.length(); i++) {
 * 					int number = Character.getNumericValue(string_num.charAt(i));
 * 					if (!visited[number]) {
 * 						visited[number] = true;
 * 						cnt += 1;
 *                                        }*            }
 * 			}
 * 			System.out.println("#" + tc + " " + nu
 * 		}
 * 		sc.close();
 */