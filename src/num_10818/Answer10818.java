package num_10818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Answer10818 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int count = Integer.parseInt(str);
		String[] s = br.readLine().split(" ");
		ArrayList<Integer> ar = new ArrayList<>();
		
		for(int i = 0; i < count; i++) {
			ar.add(Integer.parseInt(s[i]));
		}
		
		Collections.sort(ar);
		
		System.out.println(ar.get(0) + " " + ar.get(ar.size()-1));

	}

}
