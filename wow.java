class wow {
	public static void main(String[] args) {
		double sum = 0, sumPrev=-1;
		for(double p=20; p>0; p-=0.01) {
			for(float n=2; n<1000000000; n++) {
				sum+=Math.pow((1/n),p);
				if(sum==sumPrev) break;
				sumPrev=sum;
			}
			System.out.println(sum);
			sum=0;
			sumPrev=-1;
		}
	}
}