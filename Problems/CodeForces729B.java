import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CodeForces729B {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int n,m;
			String[] nm = br.readLine().split(" ");
			n = Integer.parseInt(nm[0]);
			m = Integer.parseInt(nm[1]);
			String[][] stage = new String[n][m];
			String list[];
			for(int i = 0; i < n; ++i) {
				list = br.readLine().split(" ");
				for(int j = 0; j < m; ++j) {
					stage[i][j] = list[j];
				}
			}
			int answer = 0;
			for(int i = 0; i < n; ++i) {
				int posOnes = -1;
				boolean firstOne = false;
				for(int j = 0 ; j < m; ++j) {
					if(stage[i][j].equals("1") && !firstOne) {
						answer+=j;
						posOnes = j;
						firstOne = true;
					}
					else if (stage[i][j].equals("1")){
						answer+=(2*(j-posOnes-1));
						
						posOnes = j;
					}
					if(j == m-1 && stage[i][j].equals("0") && posOnes!=-1) {
						answer+=(j-posOnes);
					}
				}
				
			}
			for(int j = 0; j < m; ++j) {
				int posOnes = -1;
				boolean firstOne = false;
				for(int i = 0 ; i < n; ++i) {
					if(stage[i][j].equals("1") && !firstOne) {
						answer+=i;
						posOnes = i;
						firstOne = true;
					}
					else if (stage[i][j].equals("1")){
						answer+=(2*(i-posOnes-1));
						posOnes = i;
					}
					if(i == n-1 && stage[i][j].equals("0") && posOnes!=-1) {
						answer+=(i-posOnes);
					}
				}
				
			}
			System.out.println(answer);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
