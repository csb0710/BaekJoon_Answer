package num_11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int last = 0;
	static int[] tree;
	static void add(int input) {
		last++;
		tree[last] = input;
		
		int index = last;
		
		for(int i = last/2; i > 0; i/=2) {
			if(input > tree[i]) {
				tree[index] = tree[i];
				index = i;
			}
			else {
				break;
			}
		}
		tree[index] = input;
		
	}
	static int delete() {
		if(last == 0) {
			return 0;
		}
		
		int result = tree[1];
		int temp = tree[last];
		tree[last] = -1;
		last--;
		tree[1] = temp;
		int index = 1;
		boolean check2 = false;
		while(index*2 <= last) {
			int temp3;
			if(tree[index*2] > tree[index*2+1]) {
				temp3 = index*2;
			}
			else {
				temp3 = index*2 + 1;
			}
			if(tree[temp3] > temp) {
				tree[index] = tree[temp3];
				index = temp3;
			}
			else {
				if(index != 1) {
					tree[index] = temp;
					check2 = true;
				}
				break;
			}
		}
		if(!check2) {
			tree[index] = temp;
		}
		return result;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 1927
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		
		tree = new int[count+1];
		tree[0] = 0;
		
		for(int i = 0; i < count; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				System.out.println(delete());
			}
			else {
				add(input);
			}
		}
		
		
	}

}
