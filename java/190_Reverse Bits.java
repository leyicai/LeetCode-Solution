public class Solution {
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		int res = 0;
		int k = 0;
		while (k < 32) {
			res <<= 1;
			res += n & 1;
			n >>>= 1;	// unsigned shift
			k++;
		}
		return res;
	}
}