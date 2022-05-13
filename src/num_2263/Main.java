package num_2263;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] in;
	static int[] post;
	static int coutn = 0;

	public static void get_pre(int min, int max, int min2, int max2) throws IOException {
		if(min > max || min2 > max2) {
			return;
		}
		int root = post[max];
		int check = -1;
		int index = min;
		int index2 = index+1;
		
		bw.append(root + " ");
		
		
		for(int i = min2; i <= max2; i++) {
			if(in[i] == root) {
				check = i;
				break;
			}
		}
		
		int wow = check - min2;
		
		
		get_pre(min, min+wow-1, min2, check-1);
		get_pre(max - (max2 - check), max-1, check+1, max2);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 2263

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		int count = Integer.parseInt(br.readLine());
		int root = 0;
		
		in = new int[count];
		post = new int[count];
		
		st = new StringTokenizer(br.readLine());
		int i = 0;
		while(st.hasMoreTokens()) {
			in[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		
		st = new StringTokenizer(br.readLine());
		i = 0;
		while(st.hasMoreTokens()) {
			post[i] = Integer.parseInt(st.nextToken());
			if(i == count-1) {
				root = post[i];
			}
			i++;
		}
		
		get_pre(0, count-1, 0, count-1);
		
		bw.flush();
		bw.close();
		
	}

}
