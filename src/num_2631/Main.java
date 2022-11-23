package num_2631;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        int[] input = new int[count];
        int[] dp = new int[count];

        list.add(-1);

        for(int i = 0; i < count; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < count; i++) {
            dp[i] = 1;
        }

        int max = 1;

        for(int i = 0; i < count; i++) {
            for(int j = 0; j < i; j++) {
                if(input[i] > input[j] && dp[j] > dp[i] - 1) {
                    dp[i] = dp[j]+1;
                }
            }
            if(max < dp[i]) {
                max = dp[i];
            }
        }


        System.out.println(count-max);

    }
}
