package num_1991;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Node {
	char data;
	int left;
	int right;
	
	public Node(char data, int left, int right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static public void preorder(Node[] tree, int i)  throws IOException{
		Node temp = tree[i];
		
		if(i == 0) 
			return;
		bw.append(temp.data +"");
		preorder(tree, temp.left);
		preorder(tree, temp.right);
		
	}
	static public void inorder(Node[] tree, int i)  throws IOException{
		Node temp = tree[i];
		
		if(i == 0) 
			return;
		inorder(tree, temp.left);
		bw.append(temp.data +"");
		inorder(tree, temp.right);
		
	}
	static public void postorder(Node[] tree, int i)  throws IOException{
		Node temp = tree[i];
		
		if(i == 0) 
			return;
		postorder(tree, temp.left);
		postorder(tree, temp.right);
		bw.append(temp.data +"");
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 1991
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		int count = Integer.parseInt(br.readLine());
		Node[] tree = new Node[count+1];

		
		for(int i = 1; i <= count; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			char temp = st.nextToken().charAt(0);
			char temp2 = st.nextToken().charAt(0);
			if(temp2 == '.')
				temp2 = '@';
			char temp3 = st.nextToken().charAt(0);
			if(temp3 == '.')
				temp3 = '@';
			tree[temp - 64] = new Node(temp, temp2 - 64, temp3 - 64);
			
		}
		preorder(tree, 1);
		bw.flush();
		System.out.println();
		inorder(tree, 1);
		bw.flush();
		System.out.println();
		postorder(tree, 1);
		bw.flush();
		bw.close();
		
		
	}

}
