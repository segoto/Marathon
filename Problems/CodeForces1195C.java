import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CodeForces1195C {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int c = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			long[] a = new long[c];
			long[] b = new long[c];
			for(int i = 0 ; i < c ; ++i) {
				a[i] = Integer.parseInt(s[i]);
			}
			s = br.readLine().split(" ");
			for(int i = 0 ; i < c ; ++i) {
				b[i] = Integer.parseInt(s[i]);
			}
			long noEscoger = 0;
			long escogerA = a[0];
			long escogerB = b[0];
			long d,e,f;
			for(int i = 1; i < c; ++i) {
				d = Math.max(escogerB, escogerA);
				e = Math.max(escogerB, noEscoger) + a[i];
				f = Math.max(escogerA, noEscoger) + b[i];
				noEscoger = d;
				escogerA = e;
				escogerB = f;
			}
			System.out.println(Math.max(noEscoger, Math.max(escogerA, escogerB)));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
