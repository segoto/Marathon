import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class porblemaA {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int q = Integer.parseInt(br.readLine());
			long friends[] = new long[3];
			String s[];
			for(int i = 0; i < q; ++i) {
				s = br.readLine().split(" ");
				friends[0] = Long.parseLong(s[0]);
				friends[1] = Long.parseLong(s[1]);
				friends[2] = Long.parseLong(s[2]);
				Arrays.sort(friends);
				long dist1_2 = Math.abs(friends[0]-friends[1]);
				long dist1_3 = Math.abs(friends[0]- friends[2]);
				long dist2_3 = Math.abs(friends[2] - friends[1]);
				long ans = dist1_2+ dist1_3 + dist2_3 - 4 > 0 ? dist1_2+ dist1_3 + dist2_3 - 4 : 0;
				System.out.println(ans);
			}
		}
		catch(Exception e) {
			
		}
	}
}
