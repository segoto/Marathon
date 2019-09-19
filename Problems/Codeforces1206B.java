import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Codeforces1206B {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int a = Integer.parseInt(br.readLine());
			long nums[] = new long[a];
			String s[] = br.readLine().split(" ");
			for(int i = 0; i < a; ++i) {
				nums[i] = Long.parseLong(s[i]);
			}
			int menosUno = 0;
			long monedas = 0;
			long ceros = 0;
			for(int i = 0; i < a; ++i) {
				long c = nums[i];
				if(c > 0) {
					monedas += (c - 1);
				}
				else if (c == 0) {
					monedas += 1;
					ceros += 1;
				}
				else {
					menosUno += 1;
					monedas += -(c+1);
				}
			}
			if(menosUno%2 == 0 || ceros > 0)
				System.out.println(monedas);
			else if(menosUno%2 !=0 && menosUno > 0 && ceros == 0) {
				System.out.println(monedas + 2);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
}
