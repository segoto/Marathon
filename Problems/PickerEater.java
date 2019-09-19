import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PickerEater {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int a[] = new int [2];
			String s[] = br.readLine().split(" ");
			a[0] = Integer.parseInt(s[0]);
			a[1] = Integer.parseInt(s[1]);
			System.out.println(a[0]>=a[1]? 1 : 0);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
