import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class UVA12195 {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			HashMap<Character, Double> num = new HashMap<>();
			num.put('W',  1.0);
			num.put('H', 0.5);
			num.put('Q', 0.25);
			num.put('E', 0.125);
			num.put('S', 0.0625);
			num.put('T', 0.03125);
			num.put('X', 0.015625);
			String s = br.readLine();
			int i, j, c;
			double suma;
			while(!s.equals("*")){
				String[] a = s.split("/");
				c = 0;	
				
				for( i = 1; i < a.length ; ++i){
					suma = 0;
					char[] arr = a[i].toCharArray();
					for(j = 0; j < arr.length; ++j ){
						suma+= num.get(arr[j]);
					}
					if( suma == 1.0){
						++c;
					}
				}
				System.out.println(c);
				s = br.readLine();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
}
