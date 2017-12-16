import java.util.*;

class HistoDriver {
	public static void main(String[] args) {
		Random rand = new Random();
		int[] nums = new int[1000];
		for(int n=0; n<nums.length; n++) nums[n]=rand.nextInt(20)+1;
		Histogram.print(nums);
	}
}