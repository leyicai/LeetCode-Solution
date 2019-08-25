class Solution {
	public void sortColors(int[] nums) {
		int lo = 0, hi = nums.length - 1, tmp;
		for (int i = 0; i < nums.lengthl; ++i) {
			while (nums[i] == 2 && i < hi) {
				tmp = nums[hi];
				nums[hi] = nums[i];
				nums[i] = tmp;
				hi--;
			}
			while (nums[i] == 0 && i > lo) {
				tmp = nums[lo];
				nums[lo] = nums[i];
				nums[i] = tmp;
				lo++;
			}
		}
	}
}
// Another version of 3 pointer
class Solution {
	public void sortColors(int[] nums) {
		int lo = 0, hi = nums.length - 1, mid = 0, tmp;
		while(mid <= hi){
			switch(nums[mid]){
				case 0:
					nums[mid] = nums[lo];
					nums[lo] = 0;
					lo++;
					mid++;
					break;
				case 1:
					mid++;
					break;
				case 2:
					nums[mid] = nums[hi];
					nums[hi] = 2;
					hi--;
				default:
					break;
			}
		}
	}
}

// two pass counting sort
class Solution {
	public void sortColors(int[] nums) {
		int num0 = 0, num1 = 0, num2 = 0;
		for (int i = 0; i < nums.length; ++i) {
			switch (nums[i]) {
				case 0:
					num0++; break;
				case 1:
					num1++; break;
				case 2:
					num2++; break;
				default:
					break;
			}
		}
		for(int i = 0; i < num0; i++)
			nums[i] = 0;
		for(int i = num0; i < num1 + num0; i++)
			nums[i] = 1;
		for(int i = num1 + num0; i < nums.length; i++)
			nums[i] = 2;
	}
}
