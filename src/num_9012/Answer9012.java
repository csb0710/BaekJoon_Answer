package num_9012;

import java.util.Scanner;
import java.util.Stack;

public class Answer9012 {

	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>();
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		scan.nextLine();
		
		while(count > 0) {
			String str = scan.nextLine();
			char[] chs = str.toCharArray();
			for(int i = 0; i < chs.length; i++) {
				if(chs[i] == '(')
					stack.add('(');
				else {
					if(stack.isEmpty()) {
						stack.add(')');
						break;
					}
					else if(!stack.isEmpty() && stack.peek() == '(')
						stack.pop();
				}	
			}
			if(stack.isEmpty())
				System.out.println("YES");
			else
				System.out.println("NO");
			stack.clear();
			count--;
		}

	}

}
