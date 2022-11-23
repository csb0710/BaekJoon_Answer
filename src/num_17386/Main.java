package num_17386;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
		long temp1 = (long)(x2-x1)*(long)(y3-y1);
		long temp2 = (long)(y2-y1)*(long)(x3-x1);
		
		long result = temp1 - temp2;

		if(result < 0) {
			return -1;
		}
		else if(result == 0){
			return 0;
		}
		else {
			return 1;
		}
		
		
		//return ((x2-x1)*(y3-y1)-(y2-y1)*(x3-x1)) < 0 ? 1 : -1;
	}

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 17386
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()); 
		
		int x3 = Integer.parseInt(st.nextToken());
		int y3 = Integer.parseInt(st.nextToken());
		int x4 = Integer.parseInt(st.nextToken());
		int y4 = Integer.parseInt(st.nextToken());
		
		int result1 = ccw(x1,y1,x2,y2,x3,y3);
		
		int result2 = ccw(x1,y1,x2,y2,x4,y4);

		int result3 = ccw(x3,y3,x4,y4,x1,y1);
				
		int result4 = ccw(x3,y3,x4,y4,x2,y2);
		
		if((result1 * result2 < 0) && (result3 * result4 < 0)) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
		
	}

}
