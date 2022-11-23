package num_14002;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int count = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] input = new int[count];
        int[] dp = new int[count];
        int[] prev = new int[count];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < count; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < count; i++) {
            dp[i] = 1;
            prev[i] = -1;
        }

        int max = 1;
        int last = -1;

        for(int i = 0; i < count; i++) {
            for(int j = 0; j < i; j++) {
                if(input[i] > input[j] && dp[j] > dp[i] - 1) {
                    dp[i] = dp[j]+1;
                    prev[i] = j;
                }
            }
            if(max < dp[i]) {
                max = dp[i];
                last = i;
            }
        }

        int temp = last;

        if(temp == -1) {
            stack.add(0);
        }

        while(temp != -1) {
            stack.add(temp);
            temp = prev[temp];
        }

        bw.append(max + "\n");

        while(!stack.empty()) {
            bw.append(input[stack.pop()] + " ");
        }
        bw.flush();
        bw.close();
    }
}
