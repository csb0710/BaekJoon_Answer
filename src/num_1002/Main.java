package num_1002;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int calculate(int x1, int y1, int x2, int y2) {
		int x = Math.max(x1, x2) - Math.min(x1, x2);
		int y = Math.max(y1, y2) - Math.min(y1, y2);
		
		int result = x*x + y*y;
		
		return result;
	}

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 1002
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int count = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			if(x1==x2 && y1 == y2 && r1 == r2) {
				bw.append("-1\n");
				continue;
			}
			
			int result = calculate(x1, y1, x2, y2);

			if(result == (r1-r2)*(r1-r2)) {
				bw.append("1\n");
				continue;
			}
			if(result < (r1-r2)*(r1-r2)) {
				bw.append("0\n");
				continue;
			}
			
			
			if(result > (r1 + r2)*(r1 + r2)) {
				bw.append("0\n");
				continue;
			}
			
			if(result == (r1 + r2)*(r1 + r2)) {
				bw.append("1\n");
				continue;
			}
			
			if (result < (r1 + r2)*(r1 + r2)) {
				bw.append("2\n");
				continue;
			}
		}
		
		bw.flush();
		bw.close();

	}

}
