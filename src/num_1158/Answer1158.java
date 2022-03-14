package num_1158;

import java.util.Scanner;

public class Answer1158 {

	public static void main(String[] args) {
		int select = 0;
		int die_count = 0;
		int num = 0;
		Scanner scan = new Scanner(System.in);
		int people_count = scan.nextInt();
		int target = scan.nextInt();
		boolean[] people = new boolean[people_count];
		String result = "<";
		
		for(int i = 0; i < people_count; i++) {
			people[i] = false;
		}
		
		while(true) {
			select = 0;
			while(true) {
				if(num == people_count)
					num = 0;
				if(!people[num])
					select++;
				if(select == target)
					break;
				num++;
			}
			people[num] = true;
			die_count++;
			if(die_count == people_count) {
				result = result + (num+1) + ">";
				break;
			}
			result = result + (num + 1) + ", ";
			num++;
		}
		
		System.out.println(result);

	}

}
