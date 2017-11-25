class Pe {
	public static void main(String[] args) {
		System.out.println("Set x: ");
		EasyReader in = new EasyReader();
		double x = in.readDouble();
		System.out.println("Set y: ");
		double y = in.readDouble();
		System.out.println("Angle: "+Math.toDegrees(Math.atan2(y,x)));
	}
}