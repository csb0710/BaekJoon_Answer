package Answer1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Stack1 {
	static private int Max_Size = 10000;
	static int[] stack = new int[Max_Size];
	static int top = -1;
	
	public static void push(int input) {
		if(top == Max_Size-1)
			return ;
		top++;
		stack[top] = input;
	}
	
	public static int pop() {
		if(top == -1)
			return -1;
		int out = stack[top];
		top--;
		return out;
	}
	
	public static int size() {
		return top+1;
	}
	
	public static int empty() {
		if(top == -1)
			return 1;
		else
			return 0;
	}
	
	public static int top() {
		if(top == -1)
			return -1;
		return stack[top];
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> result=new ArrayList<>();
		try {
			int count = br.read();
			for(int i = 0; i < count; i++) {
				String[] s = br.readLine().split(" ");
				String command = s[0];
				
				if(command.equals("push")) {
					push(Integer.parseInt(s[1]));
				}
				else if(command.equals("pop")) {
					result.add(pop());
				}
				else if(command.equals("empty")) {
					result.add(empty());
				}
				else if(command.equals("top")) {
					result.add(top());
				}
				else if(command.equals("size")) {
					result.add(size());
				}
			}

			for(int i = 0; i < count; i++) {
				System.out.println(result.get(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}