import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class CodeForces977C {
	public static void main(String[] args) {
		try (BufferedReader br  = new BufferedReader(new InputStreamReader(System.in))) {
			int a[] = new int[2];
			String[] s = br.readLine().split(" ");
			for(int i = 0; i < 2; ++i){
				a[i] = Integer.parseInt(s[i]);
			}
			s = br.readLine().split(" ");
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < a[0]; ++i){
				arr.add( Integer.parseInt(s[i]));
			}
			arr.sort(null);
			if(a[1] == a[0]){
				System.out.println(arr.get(a[1]-1));
			}
			else if(a[1]==0){
				if(arr.get(0)== 1){
					System.out.println(-1);
				}
				else{
					System.out.println(arr.get(0)-1);
				}
			}
			else{
				int min = arr.get(a[1]-1);
				int siguiente = arr.get(a[1]);
				if(min == siguiente){
					System.out.println(-1);
				}
				else {
					System.out.println(min);
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}