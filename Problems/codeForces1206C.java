import java.io.BufferedReader;
import java.io.InputStreamReader;

public class codeForces1206C {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int a = Integer.parseInt(br.readLine());
			if(a % 2 == 0)
				System.out.println("NO");
			else {
				StringBuilder p = new StringBuilder();
				StringBuilder s = new StringBuilder();
				String f = "YES";
				int[] b = new int[a];
				int[] c = new int[a];
				for(int i = 0 ; i < a; ++i) {
					if(i == 0) {
						b[0] = 1;
						c[0] = 2;
					}
					else if(i == 1) {
						b[1] = 2*a;
						c[1] = 2*a - 1;
					}
					else if(i == 2) {
						b[2] = c[0] + 1;
						c[2] = b[2] + 1;
					}
					else {
						if(i % 2 == 0) {
							b[i] = b[i-1] + 1;
							c[i] = b[i] + 1;
						}
						else {
							c[i] = c[i-1] + 1;
							b[i] = c[i] + 1;
						}
					}
				}
				for(int i = 0 ; i < a ; ++i) {
					if(i == a-1) {
						s.append(c[i]);
					}
					else {
						s.append(c[i] + " ");
					}
					p.append(b[i] + " ");
				}
				System.out.println(f + "\n" + p.toString() + s.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
