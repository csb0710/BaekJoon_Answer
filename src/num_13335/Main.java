package num_13335;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 13335
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Queue<Integer> trucks = new LinkedList<>();
		Queue<Integer> bridge = new LinkedList<>();
		
		StringTokenizer st = new StringTokenizer(scan.readLine());
		
		int truck = Integer.parseInt(st.nextToken());
		int bridge_length = Integer.parseInt(st.nextToken());
		int kg =Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(scan.readLine());
		
		for(int i = 0; i < truck; i++) {
			trucks.add(Integer.parseInt(st.nextToken()));
		}
		int time = 0;
		int count = 0;
		int sum = 0;
		while(!trucks.isEmpty() || !bridge.isEmpty()) {
			time++;
			if(time > bridge_length)
				sum -= bridge.remove();
			if(!trucks.isEmpty()) {
				if(trucks.peek() + sum <= kg && count+1 <= truck) {
					int temp = trucks.remove();
					bridge.add(temp);
					count++;
					sum += temp;
				}
				else {
					bridge.add(0);
				}
			}
			
		}
		
		bw.write(time+"");
		bw.flush();
		bw.close();
	}

}
