package num_1064;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Answer1064 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double[] point = new double[6];
		
		
		for (int i = 0; i < 6; i++)   {  
			point[i] = scan.nextInt();
		}
		
		double fail = -1;
		
		BigDecimal x1 = new BigDecimal(String.valueOf(Math.sqrt((point[0]-point[2])*(point[0]-point[2]) + (point[1]-point[3])*(point[1]-point[3]))));
		BigDecimal x2 = new BigDecimal(String.valueOf(Math.sqrt((point[0]-point[4])*(point[0]-point[4]) + (point[1]-point[5])*(point[1]-point[5]))));
		BigDecimal x3 = new BigDecimal(String.valueOf(Math.sqrt((point[2]-point[4])*(point[2]-point[4]) + (point[3]-point[5])*(point[3]-point[5]))));
		
		ArrayList<BigDecimal> ar = new ArrayList<>();
		ar.add(x1);
		ar.add(x2);
		ar.add(x3);
		
		Collections.sort(ar);
		//|| (point[0] == point[2] && point[1] == point[3] && point[0] == point[4] && point[1] == point[5])
		if(((point[1] - point[3])/(point[0] - point[2]))==((point[1] - point[5])/(point[0] - point[4]))|| (point[0] == point[2] && point[1] == point[3] && point[0] == point[4] && point[1] == point[5])) {
			System.out.println(fail);
			return;
		}
		BigDecimal x = new BigDecimal("2");
		BigDecimal max = (ar.get(1).add(ar.get(2))).multiply(x);
		BigDecimal min = (ar.get(0).add(ar.get(1))).multiply(x);
		
		
		System.out.println(max.subtract(min));
		
	}

}
