package num_23304;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String palindrom;
	
	public static boolean palindrom_check(int start, int end) {
		int temp = end - 1;
		if(start == temp)
			return true;
		for(int i = start; i < temp; i++) {
			if(palindrom.charAt(i) != palindrom.charAt(temp))
				return false;
			temp--;
		}
		
		boolean left = palindrom_check(start, (start + end)/2);
		boolean right = palindrom_check(end - (end-start)/2, end);
		if(left && right) 
			return true;
		
		else
			return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		palindrom = scan.readLine();
		if(palindrom_check(0, palindrom.length())) 
			System.out.println("AKARAKA");
		
		else
			System.out.println("IPSELENTI");

	}

}
