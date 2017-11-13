class PIDTest {
	public static void main(String[] args) {
		EasyReader in = new EasyReader();
		System.out.println("What is your target value?");
		double target = in.readDouble();
		System.out.println("What is your tolerance range (+/-)");
		double tolerance = in.readDouble(), value=0, Kp=1, I=0, D, Kd=0.1, Ki=.3, error=0, errorPrev=0, t=2;
		while((value<target-tolerance)||(value>target+tolerance)) {
			error=target-value;


			I+=error*t;

			D=(error-errorPrev)/t;

			value+=(Kp*error+Ki*I+Kd*D);
			errorPrev=error;
			System.out.println(value);
		}
	}
}