import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CodeForces1181A {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] st = br.readLine().split(" ");
			long x = Long.parseLong(st[0]);
			long y = Long.parseLong(st[1]);
			long z = Long.parseLong(st[2]);
			long a = Math.floorDiv(x, z);
			long b = Math.floorDiv(y, z);
			long c = x % z;
			long d = y % z;
			long r = a + b;
			String resp="";
			if (c >=d && d >= (z-c)) {
				++r;
				System.out.println(r +" "+(z-c));
			}
			else if(d > c && c >= (z-d)) {
				++r;
				System.out.println(r +" "+(z-d));
			}
			else if( c + d < z ) {
				System.out.println(r + " "+ 0);
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
}

