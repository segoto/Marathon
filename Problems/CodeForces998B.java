import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class CodeForces998B {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			
			int n,coins;
			String[] s = br.readLine().split(" ");
			
			n = Integer.parseInt(s[0]);
			coins = Integer.parseInt(s[1]);
			int[] numbers = new int[n];
			s = br.readLine().split(" ");
			for(int i = 0; i < n; ++i) {
				numbers[i] = Integer.parseInt(s[i]);
			}
			int even = 0;
			int odd = 0;
			ArrayList<Integer> costOfCuts = new ArrayList<>();
			for(int i = 0 ; i < n ; ++i) {
				if(numbers[i] % 2 == 0 )
					++even;
				else
					++odd;
				if(i+1 < n && even ==  odd)
					costOfCuts.add(Math.abs(numbers[i]-numbers[i+1]));
			}
			int [][] dp = new int[costOfCuts.size()+1][coins+1];
			for(int j = 0; j < coins+1; ++j) {
				dp[0][j]=0;
			}
			for(int i = 1; i < costOfCuts.size()+1; ++i) {
				int cost = costOfCuts.get(i - 1);
				for(int j = 0; j < coins+1; ++j) {
					if(cost <= j) 
						dp[i][j] = Math.max(dp[i-1][j-cost] + 1, dp[i-1][j]);
					else
						dp[i][j] = dp[i-1][j];
					
				}
			}

				
			System.out.println(dp[costOfCuts.size()][coins]);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}