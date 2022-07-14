package num_11054;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[count];
        int[] dp = new int[count];
        int[] dp2 = new int[count];

        for(int i = 0; i < count; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < count; i++) {
            dp[i] = 1;
            dp2[i] = 1;
        }

        for(int i = 0; i < count; i++) {
            for(int j = 0; j < i; j++) {
                if(input[i] > input[j] && dp[j] > dp[i] - 1) {
                    dp[i] = dp[j]+1;
                }
            }
        }

        for(int i = count-1; i >= 0; i--) {
            for(int j = count-1; j > i; j--) {
                if(input[i] > input[j] && dp2[j] > dp2[i] - 1) {
                    dp2[i] = dp2[j]+1;
                }
            }
        }

        int max = 1;

        for(int i = 0; i < count; i++) {
            if(max < dp[i] + dp2[i]) {
                max = dp[i] + dp2[i] - 1;
            }
        }

        System.out.println(max);
    }
}
