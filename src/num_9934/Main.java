package num_9934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String[] tree;
	static String[] result;
	static int count;
	public static void check_children(int check, int parent, int min, int max) {
		if(check > count) {
			return ;
		}
		result[check] += tree[(min+parent)/2] + " ";
		result[check] += tree[(max+parent)/2] + " ";
		check_children(check+1, (min+parent)/2, min, parent);
		check_children(check+1, (max+parent)/2, parent, max);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 9934
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		count = Integer.parseInt(br.readLine());
		result = new String[count+1];
		for(int i = 1; i <= count; i++) {
			result[i] = "";
		}
		tree = br.readLine().split(" ");
		System.out.println(tree[(tree.length-1)/2]);
		check_children(1, (tree.length-1)/2, 0, tree.length);
		for(int i = 1; i < count; i++) {
			System.out.println(result[i]);
		}
		
	}

}
