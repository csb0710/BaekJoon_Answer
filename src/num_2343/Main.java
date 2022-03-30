package num_2343;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static long[] videos;
	static long bluray;
	
	public static long check_video(long length) {
		long temp = 0;
		long count = 1;
		for(int i = 0; i < videos.length; i++) {
			if(temp+videos[i] <= length) {
				temp += videos[i];
			}
			else {
				count++;
				temp = videos[i];
				if(count > bluray) {
					break;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 2343
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		
		int count = Integer.parseInt(st.nextToken());
		bluray = Integer.parseInt(st.nextToken());
		
		input = br.readLine();
		st = new StringTokenizer(input);
		
		videos = new long[count];
		long sum = 0;
		long max = 0;
		
		for(int i = 0; i < count; i++) {
			videos[i] = Integer.parseInt(st.nextToken());
			sum += videos[i];
			if(max < videos[i]) {
				max = videos[i];
			}
		}
		long low = max;
		long high = sum;
		long min = 0;
		while(low <= high) {
			long mid = (low+high)/2;
			
			if(check_video(mid) <= bluray) {
				min = mid;
				high = mid - 1;
			}
			else {
				low = mid+1;
			}
			
		}
		bw.write(min+"");
		bw.flush();
		bw.close();

	}

}
