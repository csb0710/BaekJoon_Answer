package num_10818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b231 {

	public static void main(String[] args) throws IOException {
		  BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		  int N = Integer.parseInt(input.readLine());
	      StringTokenizer st = new StringTokenizer(input.readLine() , " ");
	      int[] ay = new int[N];
	      
	      for(int index = 0; index < N; index++) {
	         ay[index]  = Integer.parseInt(st.nextToken());
	      }
	      input.close();
	      Arrays.sort(ay);
	      System.out.println(ay[0] + " " + ay[N -1]);


	}

}
