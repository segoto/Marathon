import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CodeForces1217A {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int casos = Integer.parseInt(br.readLine());
			int str, inte, exp;
			for(int i = 0; i < casos; ++i) {
				String resp ="";
				String[] st = br.readLine().split(" ");
				str = Integer.parseInt(st[0]);
				inte = Integer.parseInt(st[1]);
				exp = Integer.parseInt(st[2]);
				int min = (int)Math.ceil((exp+inte-str+2)/2);
				System.out.println(Math.max(0, exp-Math.max(0, min)+1));
			}
		}
		catch(Exception e) {

		}
	}
}
