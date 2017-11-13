class testing {
	public static void main(String[] args) {
		System.out.println("print something nibba: ");
		EasyReader in = new EasyReader();
		String[] a = WordClass.alphaSort(in.readLine());
		for(int n = 0; n < a.length; n++) System.out.print(a[n]);
		System.out.println();
	}
}