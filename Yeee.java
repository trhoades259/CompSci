 class Yeee {

	public static double[][] powerMatrix = {{0,0},{0,0}};

	public static void main(String[] args) {
		driveAngle(0,1);
		for(int n = 0; n < 2; n++) for (int i = 0; i < 2; i++) System.out.println(powerMatrix[n][i]);
		turn(0);
		for(int n = 0; n < 2; n++) for (int i = 0; i < 2; i++) System.out.println(powerMatrix[n][i]);
		dampen(0.5);
		for(int n = 0; n < 2; n++) for (int i = 0; i < 2; i++) System.out.println(powerMatrix[n][i]);
		capPower();
	}


}