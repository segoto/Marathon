import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class ProblemaD {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int n = Integer.parseInt(br.readLine());
			int numbers[] = new int[n];
			String s[] = br.readLine().split(" ");
			for (int i = 0 ; i < n; ++i) {
				numbers[i] = Integer.parseInt(s[i]);
			}
			int l[] = new int[n];
			int r[] = new int[n];
			l[0] = 1;
			r[n-1] = 1;
			int ans = 0;
			for(int i = 1; i < n; ++i) {
				if(numbers[i]>numbers[i-1]) {
					l[i] = l[i-1]+1;
					ans = Math.max(ans, l[i]);
				}
					
				else
					l[i] = 1;
			}
			for(int i = n-1 ; i > 0; --i) {
				if(numbers[i-1]<numbers[i])
					r[i-1] = r[i] + 1;
				else
					r[i-1] = 1;
				
			}
			
			for(int i = 1; i <= n-2; ++i) {
				if(numbers[i+1]-numbers[i-1] > 0)
					ans = Math.max(ans, l[i-1]+r[i+1]);
			}
			System.out.println(Math.max(ans, r[0]));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
