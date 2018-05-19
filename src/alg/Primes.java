package alg;

import java.util.ArrayList;
import java.util.List;

public class Primes {

	private static List<Integer> primes = new ArrayList<Integer>();
	
	public static void main(String args[]) throws Exception {
		print("hello");
		initPrimes(100000);
		print("count primes: "+primes.size());
		int ints[] = {3,10,17,31,55};
		for (int i : ints) {
			print("test: "+i+" = "+isPrime(i));
		}
		int count = 0;
		for (int i = 2; i < 100000; i++) {
			if (isPrime(i)) count++;
		}
		print("count tests: "+count);
	}

	public static void initPrimes(int max) {
		byte b[] = new byte[max];
		for (int i = 0; i < max; i++) b[i]=1;
		int mx = (int)Math.sqrt(max);
		for (int i = 2; i < mx; i++) {
			if (b[i]==1) {
				for (int j = i*i; j < max; j=j+i) { b[j]=0;}
			}
		}
		for (int i = 2; i < max; i++) {
			if(b[i]==1) {
				print("prime: "+i);
				primes.add(i);
			}
		}
	}
	
	public static boolean isPrime(int i) {
		int min = 0;
		int max = primes.size();
		while (true) {
			if (min==max || min>max) return false;
			int avg = min+(max-min)/2;
			int tst = primes.get(avg);
			if (tst==i) return true;
			if (tst>i) {
				max=avg;
			} else {
				min=avg+1;
			}
		}
	}
	
	public static void print(String msg) {System.out.println(msg);}
}
