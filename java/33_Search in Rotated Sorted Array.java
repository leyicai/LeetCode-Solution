class Solution {
	public int search(int[] nums, int target) {
		int lo = 0, hi = nums.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[mid] < nums[lo]) {
				// 5 6 0 1 2 3 4
				if (target >= nums[lo] || target < nums[mid])
					// target = 6 or 0
					hi = mid - 1;
				else
					// target = 2
					lo = mid + 1;
			} else {
				// 2 3 4 5 6 0 1
				if (target > nums[mid] || target < nums[lo])
					// target = 6 or 0
					lo = mid + 1;

				else hi = mid - 1;
			}
		}
		return -1;
	}
}

// 2. Find the idx of smallest value using binary search
class Solution {
	public int search(int[] nums, int target) {
		int lo = 0, hi = nums.length - 1;
		// Find smallest value
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (nums[mid] > nums[hi])
				lo = mid + 1;
			else hi = mid;
		}
		// then lo = hi = idx of the smallest number
		int idx = lo;
		lo = 0; hi = nums.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			int realMid = (mid + idx) % nums.length;	//[4,5,6,7,0,1,2]+[4,5,6,7,0,1,2]=[4,5,6,7,0,1,2,4,5,6,7,0,1,2];
			if (nums[realMid] == target)
				return realMid;
			if (nums[realMid] < target)
				lo = mid + 1;
			else  hi = mid - 1;
		}
		return -1;
	}
}