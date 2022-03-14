package num_1018;

import java.util.Scanner;

public class Answer1018 {
	static public int get_min(char[][] ch, char color, int i, int j) {
		int result = 100000;
		int cpr = 0;
		for(int k = i; k < i + 8; k++) {
			for(int l = j; l < j + 8; l++) {
				if((k+l)%2 == 0 && ch[k][l] != color)
					cpr++;
				else if((k+l)%2 != 0 && ch[k][l] == color)
					cpr++;
			}
		}
		if(cpr < result)
			result = cpr;
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		if(n > 50 || n < 8 || m > 50 || m < 8)
			return;
		
		char[][] ch = new char[n][m];
		for(int i = 0; i< n; i ++) {
			String input = scan.next();
			ch[i] = input.toCharArray();
		}
		int result = 100000;
		for(int i = 0; i + 7 < n; i++) {
			for(int j = 0; j + 7 < m; j++) {
				int result_temp = Math.min(get_min(ch, 'B', i, j), get_min(ch, 'W', i, j));
				result = Math.min(result, result_temp);
			}
		}
		System.out.println(result);

	}

}
