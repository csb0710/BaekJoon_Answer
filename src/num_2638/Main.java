package num_2638;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int x;
	int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] check;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 2638

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int[][] graph = new int[x][y];
		visit = new boolean[x][y];
		Queue<Node> q = new LinkedList<>();
		int count = 0;

		for (int i = 0; i < x; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < y; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 1)
					count++;
				graph[i][j] = temp;
			}
		}
		
		boolean flag = false;
		
		if(count == 0) {
			flag = true;
		}

		int result = 0;
		
		while (count > 0) {
			q.add(new Node(0, 0));
			visit[0][0] = true;
			visit = new boolean[x][y];
			check = new boolean[x][y];
			result++;
			
			while (!q.isEmpty()) {
				Node temp = q.poll();
				for (int i = 0; i < 4; i++) {
					int tempx = temp.x + dx[i];
					int tempy = temp.y + dy[i];
					if (tempx >= 0 && tempx < x && tempy >= 0 && tempy < y && !visit[tempx][tempy]) {
						if(graph[tempx][tempy] == 1) {
							if(check[tempx][tempy]) {
								graph[tempx][tempy] = 0;
								visit[tempx][tempy] = true;
								count--;
							}
							else {
								check[tempx][tempy] = true;
							}
						}
						else {
							q.add(new Node(tempx, tempy));
							visit[tempx][tempy] = true;
						}
						
					}
				}

			}
			
//			for(int i = 0; i < x; i++) {
//				for(int j = 0; j < y; j++) {
//					System.out.print(graph[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		
		if(flag) {
			System.out.println(0);
		}
		else {
			System.out.println(result);
		}
		
		
	}

}
