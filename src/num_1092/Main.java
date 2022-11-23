package num_1092;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 1092
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int crane = Integer.parseInt(br.readLine());
		ArrayList<Integer> clist = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < crane; i++) {
			clist.add(Integer.parseInt(st.nextToken()));
		}
		
		int box = Integer.parseInt(br.readLine());
		ArrayList<Integer> blist = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < box; i++) {
			blist.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(clist, Collections.reverseOrder());
		Collections.sort(blist, Collections.reverseOrder());
		
		boolean flag = false;
		int time = 0;
		
		while(!blist.isEmpty()) {
			if(clist.get(0) < blist.get(0)) {
				flag = true;
				break;
			}
			int bindex = 0;
			time++;
			
			for(int i = 0; i < crane; i++) {
				int stand = clist.get(i);
				while(bindex < blist.size() && stand < blist.get(bindex)) {
					bindex++;
				}
				if(bindex < blist.size()) {
					blist.remove(bindex);
				}
				if(blist.isEmpty() || bindex >= blist.size()) {
					break;
				}
			}
			
		}
		
		if(flag) {
			System.out.println(-1);
		}
		else {
			System.out.println(time);
		}
	}

}
