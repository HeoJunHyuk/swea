package backjoon.Mathematics;


// 셀프 넘버
// 풀이 : d 함수에 의해 리턴된 n 을 check 배열의 인덱스로 사용하여 해당 위치를 true로 바꿈
// 10000 이하의 숫자만 확인하면 되기 때문에, n < 10001만 확인
public class Main4673 {

    public static void main(String[] args) {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] check = new boolean[10001];

        for (int i = 1; i < 10001; i++) {
            int n = d(i);
            if (n < 10001) {
                check[n] = true;
            }
            if (!check[i]) {
                System.out.println(i);
            }
        }

    }

    private static int d(int num) {
        int sum = num;

        while(num != 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }
}
