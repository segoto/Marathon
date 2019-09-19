import java.io.BufferedReader;
import java.io.InputStreamReader;
public class codeForces1203C {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int a = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			long arr[] = new long[a];
			for (int i = 0; i < a; ++i)
				arr[i] = Long.parseLong(s[i]);			
			long divisor = arr[0];
			for(int i = 1 ; i < a; ++i) {
				divisor = gcd (divisor,arr[i]);
			}
			if(divisor == 1)
				System.out.println(1);
			else {
				int r = 0;
				for (long i = 1; i < (long)Math.sqrt(divisor)+1; ++i) {
					if (divisor % i == 0) {
						++r;
						if(i != divisor/i) {
							++r;
						}
					}
						
				}
				
				System.out.println(r);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	private static long gcd(long a, long b) {
		if(a==b) {
			return a;
		}
		long max = a >= b ? a : b;
		long min = max == a ? b : a;
		while(min!=0) {
			long temp = max % min;
			max = min;
			min = temp;
		}
		return max;
	}
}
