package num_1308;

import java.util.Scanner;

public class Answer1308 {
	public static int calculate_day(int year, int month, int day) {
		int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int sum = 0;
		int leap_year = 0;
		for(int i = 0; i < year; i++) {
			if((i%4==0 && i%100 != 0) || i%400 == 0) {
				leap_year++;
			}
		}
		sum += (365*year + leap_year);
		if((year%4==0 && year%100 != 0) || year%400 == 0)
			sum ++;
		for(int i = 0; i < month; i++)
			sum += months[i];
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
		if(result > 365243)
			System.out.println("gg");
		else
			System.out.println("D-" + result);
	}

}
