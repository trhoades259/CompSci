class Angel {
	public static void main(String[] args) {
		System.out.println("angle: ");
		EasyReader in = new EasyReader();
		double a = in.readDouble();
		a = fixAngle(a);
		System.out.println("Corrected: "+a);
	}
	public static double fixAngle(double angle) {
		while(angle<=(-Math.PI) || angle>Math.PI) angle+=(2*Math.PI*(-Math.signum(angle)));
	 	return angle;
   	 }
}