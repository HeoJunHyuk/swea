package swea.D3;

import java.util.LinkedList;
import java.util.Scanner;

// [S/W 문제해결 기본] 10일차 - 비밀번호
// 풀이:
// sc.nextLine().trim() 메서드를 호출하면 문자열의 앞뒤에 있는 모든 공백 문자가 제거되고, 정리된 문자열이 반환

public class Solution1234 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1 ; tc <= 10 ; tc++) {
            int N = sc.nextInt();   // 입력받는 문자열 수
            String input = sc.next();   // 입력받은 암호문
            LinkedList<Integer> list = new LinkedList<Integer>();
            for (int i = 0; i < N; i++) {
                list.add(input.charAt(i) - '0');
            }
            int count = 0;
            while (true) {
                if (count == list.size() - 1) { // N - 1 은 runtime error 발생! -> list가 remove되면서 작아지므로 list.size()
                    break;
                }
                if (list.get(count).equals(list.get(count + 1))) {
                    list.remove(count);
                    list.remove(count); //앞에 삭제해주면 한칸 땡겨지므로 둘 다 삭제하기 위해, 한번 더 remove(count)
                    count = 0;
                } else count++;
            }
            System.out.print("#" + tc + " ");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
            }
            System.out.println();

        }
    }
}

/** 스택을 사용한 방법
 * public class Solution {
 *
 *     public static void main(String[] args) throws IOException{
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *
 *         for(int t = 1; t <= 10; t++) {
 *             Stack<Character> stack = new Stack<>(); // 문자열 저장할 스택
 *             StringTokenizer st = new StringTokenizer(br.readLine());
 *             int l = Integer.parseInt(st.nextToken()); // 문자의 총 수
 *             String str = st.nextToken(); // 번호 문자열
 *             String result = "";
 *
 *             for(int i = 0; i < l; i++) {
 *                 char cur = str.charAt(i);
 *
 *                 // 스택이 비어있거나 스택 peek가 다른 문자라면 push
 *                 if(stack.isEmpty() || cur != stack.peek()) {
 *                     stack.push(cur);
 *                 }
 *                 // 스택 peek이 현재 문자와 같다면 pop
 *                 else {
 *                     stack.pop();
 *                 }
 *             }
 *
 *             // 스택 내용물 전부 출력
 *             while(!stack.isEmpty()) {
 *                 result += stack.pop();
 *             }
 *
 *             // 뒤집어서 출력
 *             StringBuffer sb = new StringBuffer(result);
 *             System.out.println("#" + t + " " + sb.reverse().toString());
 *         }
 *     }
 * }
 *
 */