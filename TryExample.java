class TryExample {
	public static void main(String[] args) {

		try {
			int[] t= new int[5];
			int a=4, b=0, c;
			c=a/b;
			t[5]=7;
		} catch(ArithmeticException | ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}


	}
}