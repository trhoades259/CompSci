class Pe {
	public static void main(String[] args) {
		/*System.out.println("Set x: ");
		EasyReader in = new EasyReader();
		double x = in.readDouble();
		System.out.println("Set y: ");
		double y = in.readDouble();
		System.out.println("Angle: "+Math.toDegrees(Math.atan2(y,x)));*/
		System.out.println("Power:");
		EasyReader in = new EasyReader();
		double power = in.readDouble();
		System.out.println("X:");
		double x = in.readDouble();
		System.out.println("Y:");
		double y = in.readDouble();
		double[][] powerMatrix = {{0,0},{0,0}};

		if(x!=0 || y!=0) {
			for(int n=0; n<2; n++) powerMatrix[n][n] += angleDriveLeft(x,y);
        	for(int n=0; n<2; n++) powerMatrix[1-n][n] += angleDriveRight(x,y);
			double mult = getMagnitude(x,y)/getMax(powerMatrix);
       		for(int n=0; n<2; n++) for(int i=0; i<2; i++) powerMatrix[n][i]*=mult;
		}



		power/=2;
		for(int n=0; n<2; n++) for(int i=0; i<2; i++) powerMatrix[n][i]*=(1-power);

		for(int n=0; n<2; n++) for(int i=0; i<2; i++) powerMatrix[i][n]+=power-(2*power*n);
		for (int row = 0; row < powerMatrix.length; row++) {
			for (int column = 0; column < powerMatrix[row].length; column++) {
		    System.out.print(powerMatrix[row][column] + " ");
		    }
    		System.out.println();
    	}
    	System.out.println(Math.toDegrees(getAngle(x,y))+"\t"+getMagnitude(x,y)+"\t");
	}
	public static double angleDriveLeft(double x, double y) {
	    return Math.sin(getAngle(x,y)-Math.PI/4)*getMagnitude(x,y);
	}
	public static double angleDriveRight(double x, double y) {
	    return Math.cos(getAngle(x,y)-Math.PI/4)*getMagnitude(x,y);
    }
    public static double getAngle(double x, double y){
	    return Math.atan2(-y,x);
	}
	public static double getMagnitude(double x, double y){
	    double mag = Math.sqrt(x*x + y*y);
	    if (mag>1) mag=1.0;
	    return mag;
    }
    public static double getMax(double[][] powerMatrix) {
	        double max=0;
	        for(int n=0; n<2; n++) for(int i=0; i<2; i++) if(Math.abs(powerMatrix[n][i])>max) max=Math.abs(powerMatrix[n][i]);
	        return max;
    }
}