import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Codeforces698A {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int days = Integer.parseInt(br.readLine());
			int[][] activities = new int[2][days];
			String[] st = br.readLine().split(" ");
			for(int i = 0 ; i < days; ++i){
				int act = Integer.parseInt(st[i]);
				if(act == 0) {
					activities[0][i] = 0;
					activities[1][i] = 0;
				}
				else if(act == 1) {
					activities[0][i] = 1;
					activities[1][i] = 0;
				}
				else if(act==2) {
					activities[0][i] = 0;
					activities[1][i] = 1;
				}
				else{
					activities[0][i] = 1;
					activities[1][i] = 1;
				}
			}
			int dp0 = 0;
			int dp1 = activities[0][0];
			int dp2 = activities[1][0];
			for(int i = 1; i < days; ++i) {
				int temp0 = Math.max(dp2, Math.max(dp1, dp0));
				int temp1 = activities[0][i] + Math.max(dp2, dp0);
				int temp2 = activities[1][i] + Math.max(dp1, dp0);
				dp0 = temp0;
				dp1 = temp1;
				dp2 = temp2;
			}
			System.out.println(days - Math.max(dp1, Math.max(dp2, dp0)));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
