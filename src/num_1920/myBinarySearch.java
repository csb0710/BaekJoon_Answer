package num_1920;

public class myBinarySearch {

	public static int BinarySearch(int[] list, int target) {
		int low = 0;
		int high = list.length-1;
		int mid;
		
		while(high >= low) {
			mid = (low + high)/2;
			if(list[mid] == target)
				return 1;
			else if(list[mid] > target) {
				high = mid-1;
			}
			else {
				low = mid+1;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		int[] list = new int[10];
		

	}

}
