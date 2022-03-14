package Answer1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Sort2 {
	
	static void merge(int list[], int left, int mid, int right) {
		int i, j, k, l;
		int[] sorted = new int[right+1];
		i = left;
		j = mid + 1;
		k = left;
		
		while(i <= mid && j <= right) {
			if(list[i] <= list[j])
				sorted[k++] = list[i++];
			else
				sorted[k++] = list[j++];
		}
		if(i > mid)
			for(l = j; l <= right; l++)
				sorted[k++] = list[l];
		else
			for(l = i; l <= mid; l++)
				sorted[k++] = list[l];
		for(l = left; l <= right; l++)
			list[l] = sorted[l];
	}
	
	static void merge_sort(int list[], int left, int right) {
		int mid;
		if(left < right) {
			mid = (left + right) / 2;
			merge_sort(list, left, mid);
			merge_sort(list, mid + 1, right);
			merge(list, left, mid, right);
		}
	}
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			int[] input = new int[n];
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			for(int i = 0; i < n; i++) {
				int element = Integer.parseInt(br.readLine());
				input[i] = element;
			}
			merge_sort(input, 0, n-1);
			for(int i = 0; i < n; i++) {
				bw.write(String.valueOf(input[i] + "\n"));
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
