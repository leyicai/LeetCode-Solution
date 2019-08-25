// greedy
class Solution {
	public boolean canJump(int[] nums) {
		int reach = 0;
		for (int i = 0; i < nums.length; i++) {
			if (reach < i)
				return false;
			reach = Math.max(i + nums[i], reach);
		}
		return true;
	}
}

// Starting from the second to last element in the array
// we continue to decrement towards the start of the array.
// Only stopping if we hit an element with a value of 0;
// in this case we evaluate if there exist an element
// somewhere at the start of the array which has a jump value
// large enough to jump over this 0 value element.
public class Solution {
	public boolean canJump(int[] nums) {
		if (nums.length < 2) return true;

		for (int curr = nums.length - 2; curr >= 0; curr--) {
			if (nums[curr] == 0) {
				int neededJumps = 1;
				while (neededJumps > nums[curr]) {
					neededJumps++;
					curr--;
					if (curr < 0) return false;
				}
			}
		}
		return true;
	}
}