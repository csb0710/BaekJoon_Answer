package num_23309;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = scan.readLine().split(" ");
		int[] subways_Prev = new int[1000001];
		int[] subways_Next = new int[1000001];
		int subway_count = Integer.parseInt(input[0]);
		int count = Integer.parseInt(input[1]);
		
		
		StringTokenizer st = new StringTokenizer(scan.readLine());
		int first = Integer.parseInt(st.nextToken());
		int temp = first;
		for(int i = 0 ; i < subway_count-1; i++) {
			int add = Integer.parseInt(st.nextToken());
			subways_Next[temp] = add;
			subways_Prev[add]= temp;
			temp = add;
		}
		subways_Next[temp] = first;
		subways_Prev[first] = temp;
		
		while(count > 0) {
			st = new StringTokenizer(scan.readLine());
			String insert = st.nextToken();
			int target = Integer.parseInt(st.nextToken());
			if(insert.equals("BN")) {
				int num = Integer.parseInt(st.nextToken());
				int next = subways_Next[target];
				bw.write(next + "\n");
				subways_Prev[num] = target;
				subways_Next[num] = next;
				subways_Prev[next] = num;
				subways_Next[target] = num;
			}
			else if(insert.equals("BP")) {
				int num2 = Integer.parseInt(st.nextToken());
				int prev = subways_Prev[target];
				bw.write(prev + "\n");
				subways_Prev[num2] = prev;
				subways_Next[num2] = target;
				subways_Next[prev] = num2;
				subways_Prev[target] = num2;
			}
			
			else if(insert.equals("CN")) {
				int next2 = subways_Next[target];
				bw.write(next2+"\n");
				subways_Prev[subways_Next[next2]] = target;
				subways_Next[target] = subways_Next[next2];
				}
			
			else {
				int prev2 = subways_Prev[target];
				bw.write(prev2+"\n");
				subways_Next[subways_Prev[prev2]] = target;
				subways_Prev[target] = subways_Prev[prev2];
					
			}
			count--;
		}
		bw.flush();
		bw.close();
		
	}

}
