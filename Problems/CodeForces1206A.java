import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CodeForces1206A {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int a = Integer.parseInt(br.readLine());
			int[] b = new int[a];
			String[] c = br.readLine().split(" ");
			for(int i = 0 ; i < a; ++i) {
				b[i] = Integer.parseInt(c[i]);
			}
			a = Integer.parseInt(br.readLine());
			int[] d = new int[a];
			c = br.readLine().split(" ");
			for(int i = 0 ; i < a; ++i) {
				d[i] = Integer.parseInt(c[i]);
			}
			Arrays.sort(b);
			Arrays.sort(d);
			System.out.println(b[b.length-1]+ " " + d[d.length-1]);
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
}
