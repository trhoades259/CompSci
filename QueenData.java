public class QueenData {

	public static int count = 0;

    public static boolean isConsistent(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n])             return false;
            if ((q[i] - q[n]) == (n - i)) return false;
            if ((q[n] - q[i]) == (n - i)) return false;
        }
        return true;
    }

    public static void printQueens(int[] q) {
        int n = q.length;
        count++ ;
    }

    public static void enumerate(int n) {
        int[] a = new int[n];
        enumerate(a, 0);
    }

    public static void enumerate(int[] q, int k) {
        int n = q.length;
        if (k == n) printQueens(q);
        else {
            for (int i = 0; i < n; i++) {
                q[k] = i;
                if (isConsistent(q, k)) enumerate(q, k+1);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Input number (n) of Queens on a n/n board to calculate number of possibles that they can exist while not threatening eachother (lists answer from 0 to n): ");
        EasyReader in = new EasyReader() ;
        int n = in.readInt();
        String l = Integer.toString(n);
        for ( int t = 1 ; t <= n ; t++ ) {
			String r = Integer.toString(t);
			enumerate(t);
			System.out.print(t+":");
			for (int s = 0 ; s <= l.length()-r.length() ; s++) {
				System.out.print(" ");
			}
			System.out.print(count+"\n");
			count = 0;
		}
    }

}