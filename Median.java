import java.util.*;

class Median {
    public static void main(String[] args) {
		int[] a = {2,5,8,9,12,14,55,66,77};
		int[] b = {1,4,7,8,46,88};
		double median = findMedianSortedArrays(a, b);
		System.out.println(median);
	}

	public static double findMedian(int[] A, int[] B) {
		int as = A.length;
		int bs = B.length;
		int s = as + bs;
		ArrayList<Integer> set = new ArrayList<Integer>();
		int ai=0, bi=0;
		for(int i=0; i<s; i++) {
			if(bi>=(bs-1)) {
				set.add(A[ai]);
				ai++;
			}
			else if(ai>=(as-1)) {
				set.add(B[bi]);
				bi++;
			}
			else if(A[ai]<=B[bi]) {
				set.add(A[ai]);
				ai++;
			}
			else {
				set.add(B[bi]);
				bi++;
			}
		}
		if(set.size()%2==0) {
			return (set.get());
		}
	}

    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = iMin + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = iMax - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}