class CrossProduct {
	public static void main(String[] args) {
		int[] sums = {8,7,6};
		int[] rights = {6,5,4,6,5,4};
		int[] vectors = new int[6];
		EasyReader in = new EasyReader();
		for(int i=0; i<2; i++) {
			System.out.println("Please enter the values for vector "+(i+1)+" seperated by spaces:");
			for(int n=0; n<3; n++) vectors[3*i+n]=in.readInt();
		}
		int[] result = new int[3];
		int rc = 0;
		for(int i=0; i<3; i++) {
			result[i]=0;
			for(int n=1;  n>-2; n-=2) {
				result[i]+=n*(vectors[sums[i]-rights[rc]-1]*vectors[rights[rc]-1]);
				rc++;
			}
		}
		System.out.print("<");
		for(int i=0; i<3; i++) System.out.print(result[i]+",");
		System.out.print("\b>\n");
	}
}