package num_17143;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Node {
	int x;
	int y;
	int s;
	int d;
	int z;
	
	public Node(int x, int y, int s, int d, int z) {
		this.x = x;
		this.y = y;
		this.s = s;
		this.d = d;
		this.z = z;
	}
	
}

public class Main {
	static int[][] graph;
	static Node[] sharks;
	static int r;
	static int c;
	static int count;
	
	public static Node move(Node shark) {
		if(shark.d == 1) {
			if(((r-shark.x+shark.s)/(r-1))%2 == 0) {
				return new Node(r-((r-shark.x+shark.s)%(r-1)), shark.y, shark.s, shark.d, shark.z);
			}
			else {
				return new Node(1+((r-shark.x+shark.s)%(r-1)), shark.y, shark.s, shark.d+1, shark.z);
			}
		}
		else if(shark.d == 2) {
			if(((shark.x-1+shark.s)/(r-1))%2 != 0) {
				return new Node(r-((shark.x-1+shark.s)%(r-1)), shark.y, shark.s, shark.d-1, shark.z);
			}
			else {
				return new Node(1+(shark.x-1+shark.s)%(r-1), shark.y,  shark.s, shark.d, shark.z);
			}
		}
		else if(shark.d == 3) {
			if(((shark.y-1+shark.s)/(c-1))%2 != 0) {
				return new Node(shark.x, c-((shark.y-1+shark.s)%(c-1)), shark.s, shark.d+1, shark.z);
			}
			else {
				return new Node(shark.x, 1+(shark.y-1+shark.s)%(c-1),  shark.s, shark.d, shark.z);
			}
		}
		else {
			if((c-shark.y+shark.s)/(c-1)%2 == 0) {
				return new Node(shark.x, c-((c-shark.y+shark.s)%(c-1)), shark.s, shark.d, shark.z);
			}
			else {
				return new Node(shark.x, 1+((c-shark.y+shark.s)%(c-1)), shark.s, shark.d-1, shark.z);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 17143
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		count = Integer.parseInt(st.nextToken());
		
		graph = new int[r+1][c+1];
		sharks = new Node[count+1];
		
		for(int i = 1; i < count+1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			sharks[i] = new Node(x, y, s, d, z);
            graph[x][y] = i;
		}
		
		int result = 0;
		
		for(int j = 1; j < r+1; j++) {
			if(graph[j][1] != 0 && graph[j][1] != -1) {
				result += sharks[graph[j][1]].z;
				sharks[graph[j][1]].x = -1;
				graph[j][1] = 0;
				break;
			}
		}
		
		for(int i = 2; i < c+1; i++) {
			if(count == 0) {
				break;
			}
			
			for(int j = 1; j < count+1; j++) {
				Node temp = sharks[j];
				
				if(temp.x == -1)
					continue;
				
				if(j == graph[temp.x][temp.y]) // Æ²·È´ø ºÎºÐ
					graph[temp.x][temp.y] = 0;
				
				Node temp2 = move(temp);
				if(graph[temp2.x][temp2.y] != 0) {
					if(graph[temp2.x][temp2.y] < j) {
						int temps = graph[temp2.x][temp2.y];
						if(sharks[temps].z < temp2.z) {
							sharks[temps].x = -1;
							graph[temp2.x][temp2.y] = j;
							sharks[j] = temp2;
						}
						else {
							sharks[j].x = -1;
							continue;
						}
					}
					else {
						graph[temp2.x][temp2.y] = j;
						sharks[j] = temp2;
					}
				}
				else {
					graph[temp2.x][temp2.y] = j;
					sharks[j] = temp2;
				}
			}
			
			for(int j = 1; j < r+1; j++) {
				if(graph[j][i] != 0 && graph[j][i] != -1) {
					result += sharks[graph[j][i]].z;
					sharks[graph[j][i]].x = -1;
					graph[j][i] = 0;
					break;
				}
			}
		}
		
		System.out.println(result);
	}

}