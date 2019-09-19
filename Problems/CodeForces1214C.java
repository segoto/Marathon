import java.io.BufferedReader;
import java.io.InputStreamReader;



public class CodeForces1214C {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int a = Integer.parseInt(br.readLine());
			if( a%2==1) {
				System.out.println("No");
			}
			else {
				char[] b = br.readLine().toCharArray();
				int resp = 0;
				boolean r = true;
				for(int i = 0; i < a; ++i) {
					if(b[i]=='(') {
						++resp;
					}
					else {
						--resp;
					}
					if(resp==-2) {
						r = false;
						break;
					}
				}
				if (!r || resp > 0) {
					System.out.println("No");
				}
				else {
					System.out.println("Yes");
				}
			}
		}
		catch(Exception e) {
		}
	}
}
