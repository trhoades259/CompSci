import java.math.BigInteger;

class PrimeTest {
	public static void main(String[] args) {
		for(int value=2; value<=100; value++) {
			if(((factorial(value-1).add((new BigInteger).valueOf(1)))%value)==0) System.out.println(value);
		}
	}

	public static BigInteger factorial(int num) {
		BigInteger value = BigInteger.valueOf(1);
		for(int current = 2; current<=num; current++) value = value.multiply(current);
		return value;
	}
}