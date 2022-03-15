package num_1064;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Point {
	double x;
	double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double get_length(Point point2) {
		double x_length = (x-point2.x)*(x-point2.x);
		double y_length = (y-point2.y)*(y-point2.y);
		
		return Math.sqrt(x_length + y_length);
	}
	
	public boolean get_same(Point point2) {
		if(x==point2.x && y==point2.y)
			return true;
		return false;
	}
	
}

public class Answer1064 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double[] point = new double[6];
		
		
		for (int i = 0; i < 6; i++)   {  
			point[i] = scan.nextInt();
		}
		
		Point point1 = new Point(point[0], point[1]);
		Point point2 = new Point(point[2], point[3]);
		Point point3 = new Point(point[4], point[5]);
		
		double fail = -1;
		
		if((point1.get_same(point2) && point1.get_same(point3))) {
			System.out.println(fail);
			return;
		}
		else if((point2.x-point1.x)*(point3.y-point1.y) == (point2.y-point1.y)*(point3.x-point1.x)) {
			System.out.println(fail);
			return;
		}
		
		double max = Math.max(point1.get_length(point2), point1.get_length(point3));
		double min = Math.min(point1.get_length(point2), point1.get_length(point3));
		double real_max = Math.max(max, point2.get_length(point3));
		double second = Math.min(max, point2.get_length(point3));
		double real_min = Math.min(min, point2.get_length(point3));
		
		double length_max =  (real_max+second)*2;
		double length_min = (real_min+second)*2;
		
		System.out.println(length_max-length_min);
		
	}

}
