package num_17387;

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
		
	}
	
	public static boolean check_x(int x1, int x2, int x3, int x4) {
		if(Math.max(x1, x2) < Math.max(x3, x4)) {
			if(Math.max(x1, x2) > Math.min(x3, x4)) {
				return true;
			}
		}
		else if(Math.max(x1, x2) > Math.max(x3, x4)) {
			if(Math.min(x1, x2) < Math.max(x3, x4)) {
				return true;
			}
		}
		
		return false;
	}

	public static boolean check_y(int y1, int y2, int y3, int y4) {
		if(Math.max(y1, y2) < Math.max(y3, y4)) {
			if(Math.max(y1, y2) > Math.min(y3, y4)) {
				return true;
			}
		}
		else if(Math.max(y1, y2) > Math.max(y3, y4)) {
			if(Math.min(y1, y2) < Math.max(y3, y4)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean same(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		return (x1==x3&&y1==y3) || (x2==x3&&y2==y3) || (x1==x4&&y1==y4) || (x2==x4&&y2==y4);
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 17387
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
		
		if((result1 * result2 <= 0) && (result3 * result4 <= 0)) {
			if((result1 * result2 == 0) && (result3 * result4 == 0)) {
				if(check_x(x1,x2,x3,x4) || check_y(y1,y2,y3,y4) || same(x1,y1,x2,y2,x3,y3,x4,y4)) {
					System.out.println(1);
				}
				else {
					System.out.println(0);
				}
			}
			else {
				System.out.println(1);
			}
		}
		else {
			System.out.println(0);
		}
		
//		 
	}

}
