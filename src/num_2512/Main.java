package num_2512;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 2512
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		int[] money = new int[count];
		int max = 0;
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);

		
		for(int i = 0; i < count; i++) {
			money[i] = Integer.parseInt(st.nextToken());
			if(max < money[i])
				max = money[i];
		}
		int max_money = Integer.parseInt(br.readLine());
		
		int left = 0;
		int right = max;
		int result = 0;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			int sum = 0;
			
			for(int i = 0; i < count; i++) {
				if(money[i] <= mid) {
					sum += money[i];
				}
				else {
					sum += mid;
				}
			}
			
			if(sum <= max_money) {
				result = mid;
				left = mid + 1;
			}
			else {
				right = mid -1;
			}
			
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}

}
