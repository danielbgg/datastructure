package book1.chapter5.hashed;

public class fourKPlus3 {
	public static int fourKPlus3(int n, int pct) // from Figure 5.16
	{
		boolean fkp3 = false;
		boolean aPrime = false;
		int prime, highDivisor, d;
		double pctd = pct;
		prime = (int) (n * (1.0 + (pctd / 100.0))); // guess the prime pct
													// percent larger than n
		if (prime % 2 == 0) // if even make the prime guess odd
			prime = prime + 1;
		while (fkp3 == false) // not a 4k+3 prime
		{
			while (aPrime == false) // not a prime
			{
				highDivisor = (int) (Math.sqrt(prime) + 0.5);
				for (d = highDivisor; d > 1; d--) {
					if (prime % d == 0)
						break;
				}
				if (d != 1) // prime not found
					prime = prime + 2;
				else
					aPrime = true;
			}// end of the prime search loop
			if ((prime - 3) % 4 == 0)
				fkp3 = true;
			else {
				prime = prime + 2;
				aPrime = false;
			}
		}// end of 4k+3 prime search loop
		return prime;
	}
}