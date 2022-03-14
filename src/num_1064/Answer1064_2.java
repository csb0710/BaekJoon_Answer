package num_1064;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Answer1064_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double[] point = new double[6];
		
		for (int i = 0; i < 6; i++)   {  
			point[i] = scan.nextInt();
		}
		
		double fail = -1;
		
		double x1 = Math.sqrt((point[0]-point[2])*(point[0]-point[2]) + (point[1]-point[3])*(point[1]-point[3]));
		double x2 = Math.sqrt((point[0]-point[4])*(point[0]-point[4]) + (point[1]-point[5])*(point[1]-point[5]));
		double x3 = Math.sqrt((point[2]-point[4])*(point[2]-point[4]) + (point[3]-point[5])*(point[3]-point[5]));
		
		ArrayList<Double> ar = new ArrayList<>();
		ar.add(x1);
		ar.add(x2);
		ar.add(x3);
		
		Collections.sort(ar);
		
		if(((point[1] - point[3])/(point[0] - point[2]))==((point[1] - point[5])/(point[0] - point[4]))|| (point[0] == point[2] && point[1] == point[3] && point[0] == point[4] && point[1] == point[5])) {
			System.out.println(fail);
			return;
		}
		double max = (ar.get(1) + ar.get(2))*2;
		double min = (ar.get(0) + ar.get(1))*2;
		
		if(max < ((ar.get(0) + ar.get(2))*2))
			max = (ar.get(0) + ar.get(2))*2;
		else if(max < ((ar.get(0) + ar.get(1))*2))
			max = (ar.get(0) + ar.get(1))*2;
		
		if(min > (ar.get(0) + ar.get(2))*2)
			min = (ar.get(0) + ar.get(2))*2;
		else if(min > (ar.get(1) + ar.get(2))*2)
			min = (ar.get(1) + ar.get(2))*2;
		
		System.out.println(max-min);

	}

}
