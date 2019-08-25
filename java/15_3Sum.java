// O(n^2)
// fix 1 point, then use 2 pointers
// 2 pointers: O(n)
class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;		// the first element must not >0
			int l = i + 1, h = nums.length - 1, sum = -nums[i];
			if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
				// skip duplicate nums
				while (l < h) {
					if (nums[l] + nums[h] == sum) {
						res.add(Arrays.asList(nums[i], nums[l], nums[h]));
						while (l < h && nums[l] == nums[l + 1])
							l++;
						while (l < h && nums[h] == nums[h - 1])
							h--;
                        l++; h--;
					} else if (nums[l] + nums[h] < sum)
						l++;
					else
						h--;
				}
			}
		}
		return res;
	}
}