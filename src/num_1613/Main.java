package num_1613;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[][] dis2 = new int[m+1][m+1];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			dis2[s][l] = -1;
			dis2[l][s] = 1;
		}
		
		for(int k = 1; k < m+1; k++) {
			for(int i = 1; i < m+1; i++) {
				for(int j = 1; j < m+1; j++) {
					if(dis2[i][k] + dis2[k][j] == -2) {
						dis2[i][j] = -1;
						dis2[j][i] = 1;
					}
				}
			}
		}
		
		int count = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			bw.append(dis2[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] + "\n");
		}
		
		bw.flush();
		bw.close();
	}

}
