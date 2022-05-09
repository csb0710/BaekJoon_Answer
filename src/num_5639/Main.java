package num_5639;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
	int data;
	Node left = null;
	Node right = null;
	
	public Node(int data) {
		this.data = data;
	}
}

public class Main {
	static int[][] tree;
	static Node root;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void insert_tree(int input, Node root) {
		if(input < root.data) {
			if(root.left == null) {
				root.left = new Node(input);
			}
			else {
				insert_tree(input, root.left);
			}
		}
		else if(input > root.data) {
			if(root.right == null) {
				root.right = new Node(input);
			}
			else {
				insert_tree(input, root.right);
			}
		}
	}
	static public void postorder(Node temp)  throws IOException{	
		if(temp == null) 
			return;
		postorder(temp.left);
		postorder(temp.right);
		bw.append(temp.data +"\n");
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 5639
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> inputs = new ArrayList<>();
		String insert;
		
		root = new Node(Integer.parseInt(br.readLine()));
		
		while (true) {
            insert = br.readLine();
            if (insert == null || insert.equals(""))
                break;
            insert_tree(Integer.parseInt(insert), root);
        }
		postorder(root);
		bw.flush();
		bw.close();

	}

}
