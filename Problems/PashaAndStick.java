import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PashaAndStick {
	
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int a = Integer.parseInt(br.readLine());
			if(a%2==1) {
				System.out.println(0);
			}
			else {
				if((a/2)%2==1)
					System.out.println(a/4);
				else
					System.out.println((a/4) -1);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
