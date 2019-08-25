class Solution {
	public int[] searchRange(int[] nums, int target) {
		int[] res = new int[] { -1, -1};
		int lo = 0, hi = nums.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (nums[mid] == target) {
				int first = mid, last = mid;
				while (first > 0 && nums[first] == nums[first - 1])
					first--;
				while (last < nums.length - 1 && nums[last] == nums[last + 1])
					last++;
				return new int[] {first, last};
			}
			if (nums[mid] < target)
				lo = mid + 1;

			else hi = mid - 1;
		}

		return res;
	}
}

// 2. Use two binary search.
// First search the left idx, then search for right idx.
class Solution {
	public int[] searchRange(int[] nums, int target) {
		int[] res = new int[] { -1, -1};

		if(nums == null || nums.length == 0)
			return res;

		int lo = 0, hi = nums.length - 1;

		// first search
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (nums[mid] < target)
				lo = mid + 1;

			else hi = mid;
		}
		if (nums[lo] != target)
			return res;
		res[0] = lo;

		// second search
		// mid is biased to the right part
		hi = nums.length - 1;
		while (lo < hi) {
			int mid = (lo + hi) / 2 + 1;
			if (nums[mid] > target)
				hi = mid - 1;

			else lo = mid;
		}
		res[1] = hi;

		return res;
	}
}