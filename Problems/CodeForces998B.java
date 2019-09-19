import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class CodeForces998B {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			String[] st = br.readLine().split(" ");
			int n = Integer.parseInt(st[0]);
			int b = Integer.parseInt(st[1]);
			int nums[] = new int[n];
			st = br.readLine().split(" ");
			for( int i = 0; i<n ; ++i){
				nums[i] = Integer.parseInt(st[i]);
			}
			int[] pares = new int[n];
			int[] impares = new int[n];
			pares[0] = 0;
			impares[0] = 0;
			for(int i = 0 ; i< n ; ++i){
				if(nums[i] % 2 == 0){
					if(i == 0)
						pares[i] = 1;
					else{
						pares[i] = pares[i-1]+1;
						impares[i] = impares[i-1];
					}
						
				}
					
				else{
					if(i == 0){
						impares[i] = 1;
					}
						
					else{
						impares[i] = impares[i-1]+1;
						pares[i] = pares[i-1];
					}
						
				}
			}
			
			ArrayList<Integer> posiblesCortes = new ArrayList<>();
			for(int i = 0; i < n-1; ++i){
				if(pares[i] == impares[i])
					posiblesCortes.add(i);
			}
			int[][] dp = new int[posiblesCortes.size()+1][b+1];
			
			for(int i = 0; i<b+1;++i){
				dp[0][i] = 0;
			}
			for(int i = 1 ; i < posiblesCortes.size()+1; ++i){
				for(int j = 0; j < b+1 ; ++j){
					int  pos = posiblesCortes.get(i-1);
					int ele1 = nums[pos];
					int ele2 = nums[pos+1];
					int peso = ele1 < ele2 ? ele2-ele1 : ele1-ele2;
					if(j == 0){
						dp[i][j] = 0;
					}
					else if (peso > j){
						
						dp[i][j] = dp[i-1][j];
					}
					else if(peso  <= j){
						
						dp[i][j] = Math.max(dp[i-1][j-peso] +1, dp[i-1][j]);
					}
				}
			}
			System.out.println(dp[posiblesCortes.size()][b]);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}