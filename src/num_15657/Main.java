package num_15657;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	static boolean[] bit;
	static int[] insert;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void dfs(int n, int m, int depth, int check) throws IOException {
		if (depth == m) {
			for (int temp : arr) {
				bw.write(temp + " ");
			}
			bw.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			if (check > insert[i]) {
				continue;
			}
			arr[depth] = insert[i];
			dfs(n, m, depth + 1, insert[i]);

		}
	}

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 15657

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		m = Integer.parseInt(inputs[1]);

		arr = new int[m];
		bit = new boolean[n];
		insert = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			insert[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(insert);

		dfs(n, m, 0, 0);

		bw.flush();
		bw.close();

	}

}
