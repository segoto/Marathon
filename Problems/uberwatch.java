import java.io.BufferedReader;
import java.io.InputStreamReader;

public class uberwatch {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] st = br.readLine().split(" ");
			int a = Integer.parseInt(st[0]);
			int b = Integer.parseInt(st[1]);
			if(a<=b) {
				System.out.println(0);
			}
			else {
				st = br.readLine().split(" ");
				int[] c = new int[a];
				for(int i = 0 ; i < a; ++i) {
					c[i] = Integer.parseInt(st[i]);
				}
				int[] d = new int[a];
				d[a-1] =  c[a-1];
				for(int i = a-2; i>=b; --i) {
					if(i+b>=a) {
						d[i] = Math.max(c[i], d[i+1]);
					}
					else {
						d[i] = Math.max(d[i+b]+c[i],d[i+1]);
					}
				}
				System.out.println(d[b]);
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
}
