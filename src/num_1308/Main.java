package num_1308;

import java.util.Scanner;

public class Main {
	public static boolean leaf_year(int year) {
		if((year%4==0 && year%100 != 0) || year%400 == 0) {
			return true;
		}
		return false;
	}
	public static int calculate_day(int year, int month, int day) {
		int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int sum = 0;
		int leap_year = 0;
		for(int i = 0; i < year; i++) {
			if(leaf_year(i)) {
				sum+= 366;
			}
			else
				sum+= 365;
		}
		for(int i = 0; i < month-1; i++) {
			if(i == 1 && leaf_year(year)) {
				sum += 29;
			}
			else {
				sum += months[i];
			}
		}
		sum += day;
		
		return sum;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int year1, month1, day1;
		int year2, month2, day2;
		
		year1 = scan.nextInt();
		month1 = scan.nextInt();
		day1 = scan.nextInt();
		year2 = scan.nextInt();
		month2 = scan.nextInt();
		day2 = scan.nextInt();
		
		int result = calculate_day(year2, month2, day2) - calculate_day(year1, month1, day1);
		if(result >= 365243)
			System.out.println("gg");
		else
			System.out.println("D-" + result);
	}

}

