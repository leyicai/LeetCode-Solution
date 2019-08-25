class Solution {
public:
	double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
		int n, n1, n2, i = 0, j = 0;
		n1 = nums1.size(); n2 = nums2.size();
		if (n1 == 0) {
			return (double)(nums2[(n2 - 1) / 2] + nums2[n2 / 2]) / 2.0;
		}
		if (n2 == 0) {
			return (double)(nums1[(n1 - 1) / 2] + nums1[n1 / 2]) / 2.0;
		}
		n = n1 + n2;
		int mid1 = kth(nums1, nums2, 0, 0, (n + 1) / 2);
		int mid2 = kth(nums1, nums2, 0, 0, (n + 2) / 2);
		cout << mid1 << " " << mid2 << endl;
		return (double)(mid1 + mid2) / 2.0;
	}
	// find the kth in a[i~end] and b[j~end]
	int kth(vector<int>& a, vector<int>& b, int i, int j, int k) {
		// let a shorter than b
		if (a.size() - i > b.size() - j ) {
			return kth(b, a, j, i, k);
		}
		if (i >= a.size()) {
			return b[j + k - 1];
		}
		if (k == 1) {
			return min(a[i], b[j]);
		}
		if (j >= b.size()) {
			return b[j - 1];
		}
		if (a[i] < b[j]) {
			return kth(a, b, i + 1, j, k - 1);
		}
		else return kth(a, b, i, j + 1, k - 1);
	}
};

// ignore half part of A and B each step recursively by comparing the median of remaining A and B
// if aMid < bMid: keep aRight + bLeft
// else keep aleft + bright
double kth(vector<int>& a, vector<int>& b, int i, int j, int k) {
	if (i >= a.size())
		return b[j + k - 1];
	if (j >= b.size())
		return a[i + k - 1];
	if (k == 1)
		return min(a[i], b[j]);

	int aMid = INT_MAX, bMid = INT_MAX;
	if (i + k / 2 - 1 < a.size())
		aMid = a[i + k / 2 - 1];
	if (j + k / 2 - 1 < b.size())
		bMid = b[j + k / 2 - 1];
	if (aMid < bMid)
		return kth(a, b, i + k / 2, j, k - k / 2);
	else
		return kth(a, b, i, j + k / 2, k - k / 2);
}

// split array a, b into two halves
// left:                 right:
// a[0] ... a[i-1](l1) | a[i](r1) ... a[n1-1]
// b[0] ... b[j-1](l2) | b[j](r2) ... b[n2-1]
// imagine 1 2 3 4 as # 1 # 2 # 3 # 4 #
// len 4 --> 9
// then for 2 arr, len = 2*n1 + 2*n2 + 2
// c1, c2 are cut pos in extended array
// c1 + c2 = n1 + n2
// l1 = a[(c1-1) / 2], r1 = a[c1/2]
// l2 = b[(c2-1) / 2], r2 = b[c2/2]
// use condition: l1 <= r2 && l2 <= r1 to find c1, c2
// if L1 > R2, it means there are too many large numbers on the left half of A1, then we must move C1 to the left (i.e. move C2 to the right);
// If L2 > R1, then there are too many large numbers on the left half of A2, and we must move C2 to the left.
// After we find the cut, the median can be computed as (max(L1, L2) + min(R1, R2)) / 2;
// cut on the shorter array first.
// The only edge case is when a cut falls on the 0th(first) or the 2Nth(last) position.
// For instance, if C2 = 2N2, then R2 = A2[2*N2/2] = A2[N2], which exceeds the boundary of the array.
// To solve this problem, we can imagine that both A1 and A2 actually have two extra elements, INT_MAX at A[-1] and INT_MAX at A[N].
// These additions don't change the result, but make the implementation easier:
// If any L falls out of the left boundary of the array, then L = INT_MIN, and if any R falls out of the right boundary, then R = INT_MAX.

class Solution {
public:
	double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
		int n1, n2, c1, c2;
		double l1, l2, r1, r2;
		n1 = nums1.size(); n2 = nums2.size();
		if (n1 > n2) {
			return findMedianSortedArrays(nums2, nums1);
		}
		int lo = 0, hi = 2 * n1;
		while (lo <= hi) {
			c1 = (lo + hi) / 2;
			c2 = n1 + n2 - c1;
			l1 = c1 ? nums1[(c1 - 1) / 2] : INT_MIN;
			l2 = c2 ? nums2[(c2 - 1) / 2] : INT_MIN;
			r1 = (c1 != 2 * n1) ? nums1[c1 / 2] : INT_MAX;
			r2 = (c2 != 2 * n2) ? nums2[c2 / 2] : INT_MAX;
			if (l1 > r2)		// too many on left of nums1
				hi = c1 - 1;
			else if (l2 > r1)
				lo = c1 + 1;
			else
				return (max(l1, l2) + min(r1, r2)) / 2.0;
		}
        return -1;
	}
};
