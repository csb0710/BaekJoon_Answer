package num_11758;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
		int temp1 = (x2-x1)*(y3-y1);
		int temp2 = (y2-y1)*(x3-x1);
		
		int result = temp1 - temp2;
		
		if(result < 0) {
			return -1;
		}
		else if(result == 0){
			return 0;
		}
		else {
			return 1;
		}

	}

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 11758
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()); 
		
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()); 
		
		int x3 = Integer.parseInt(st.nextToken());
		int y3 = Integer.parseInt(st.nextToken());
		
		
		System.out.println(ccw(x1,y1,x2,y2,x3,y3));
	}

}
