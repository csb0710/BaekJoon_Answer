package num_1312;

import java.awt.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		Scanner scan = new Scanner(System.in);
		
		int count = scan.nextInt();
		scan.nextLine();
		String check;
		String check2;
		
		while(count > 0) {
			check = scan.next();
			check2 = scan.next();
			
			if(map.get(check)!=null && check2.equals("leave")) {
				map.remove(check);
			}
			
			else if(map.get(check) == null)
				map.put(check, check2);
			
			count--;
		}
		
		Object[] mapKey = map.keySet().toArray();
		Arrays.sort(mapKey, Collections.reverseOrder());
		
		for(int i =0; i< mapKey.length; i++) {
			System.out.println((String)mapKey[i]);
		}
	}

}
