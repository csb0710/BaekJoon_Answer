package num_15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	static int c;
	static ArrayList<Node> house;
	static ArrayList<Node> chicken;
	static Node[] chi;
	static int result = Integer.MAX_VALUE;
	
	public static void find(int depth, int prev) {
		if(depth == c) {
			get();
			return;
		}
		
		for(int i = prev + 1; i < chicken.size(); i++) {
			chi[depth] = chicken.get(i);
			find(depth+1, i);
		}
	}
	
	public static void get() {
		int count = 0;
		
		for(int i = 0; i < house.size(); i++) {
			Node temp = house.get(i);
			int gg = Integer.MAX_VALUE;
			for(int j = 0; j < c; j++) {
				Node temp2 = chi[j];
				int cal = Math.abs(temp.x - temp2.x) + Math.abs(temp.y - temp2.y);
				
				gg = Math.min(cal, gg);
			}
			count += gg;
		}
		
		result = Math.min(count, result);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		chi = new Node[c];
		
		for(int i = 1; i < r+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < r+1; j++) {
				int temp = Integer.parseInt(st.nextToken());
				
				if(temp == 1) {
					house.add(new Node(i, j));
				}
				else if(temp == 2) {
					chicken.add(new Node(i, j));
				}
			}
		}
		
		find(0, -1);
		
		System.out.println(result);

	}

}
